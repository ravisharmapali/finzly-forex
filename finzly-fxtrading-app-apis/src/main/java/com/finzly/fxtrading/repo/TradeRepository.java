package com.finzly.fxtrading.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxtrading.entities.Trade;

@Repository
public class TradeRepository {

	@Autowired
	SessionFactory factory;

	public Trade createNewFxTrade(Trade trade) {

		Session session = factory.openSession();

		Trade savedTrade = (Trade) session.save(trade);
		session.beginTransaction().commit();

		return savedTrade;
	}

	public Map<String, Trade> confirmNewFxTrade(int tradeId) {
//		Map<String, Trade> mapData = null;
//		// fetch trade with id
//		Session session = factory.openSession();
//		Trade trade = session.get(Trade.class, tradeId);
//		if (trade != null) {
//			trade.setBooked(true);
//			Trade confirmedTrade = (Trade) session.save(trade);
//			double txnAmt = confirmedTrade.getCurrency().getCurrencyRate() * confirmedTrade.getAmountToTransfer();
//			mapData = new HashMap<>();
//			String custName = confirmedTrade.getCustomerName();
//			mapData.put("You are transferring INR " + txnAmt + " to " + custName, confirmedTrade);
//
//		} else {
//			mapData = new HashMap<>();
//			mapData.put("trade not found with id " + tradeId, trade);
//		}
//		return mapData;

		return null;
	}

	public Trade getTradeById(int tradeId) {
		Session session = factory.openSession();
		Trade trade = session.get(Trade.class, tradeId);
		if (trade != null) {
			return trade;
		} else {
			return null;
		}

	}

	public boolean deleteTrade(int tradeId) {
		Session session = factory.openSession();
		Trade trade = session.get(Trade.class, tradeId);
		if (trade != null && !trade.isBooked()) {
			session.remove(trade);
			return true;
		} else {
			return false;
		}

	}

	public List<Trade> getAllTrades() {
		Session session = factory.openSession();
		List<Trade> list = session.createQuery("From Trade", Trade.class).list();
		return list;

	}

	public Trade updateTrade(Trade trade, int tradeId) {
		Session session = factory.openSession();
		Trade foundTrade = session.get(Trade.class, tradeId);
		foundTrade.setCustomerName(trade.getCustomerName());
//		foundTrade.setCurrency(trade.getCurrency());
		foundTrade.setCurrencyPair(trade.getCurrencyPair());
		foundTrade.setAmountToTransfer(trade.getAmountToTransfer());
		foundTrade.setBooked(trade.isBooked());
		session.save(foundTrade);
		return foundTrade;
	}

}