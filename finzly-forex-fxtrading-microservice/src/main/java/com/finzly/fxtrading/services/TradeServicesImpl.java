package com.finzly.fxtrading.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtrading.entities.Trade;
import com.finzly.fxtrading.repo.TradeRepository;

/**
 * service implementations for Trade contains business logic
 */
@Service
public class TradeServicesImpl implements TradeServices {

	// service method takes help of repository for various db related
	// operations.
	@Autowired
	TradeRepository repository;

	@Override
	public Trade createNewFxTrade(Trade trade) {
		trade.setBooked(false);
		Trade savedTrade = repository.save(trade);

		return savedTrade;

	}

	/**
	 * confirmNewFxTrade method will take trade id and set the booked trade as
	 * confirm .
	 */
	@Override
	public Map<String, Trade> confirmNewFxTrade(int tradeId) {
		Map<String, Trade> mapData = null;
		Trade findById = repository.findById(tradeId).get();
		if (findById != null) {
			// set the value of isBooked as true
			findById.setBooked(true);
			Trade confirmedTrade = repository.save(findById);
			mapData = new HashMap<>();
			double txnAmt = confirmedTrade.getTradeRate() * confirmedTrade.getAmountToTransfer();
			String custName = confirmedTrade.getCustomerName();
			mapData.put("You are transferring INR " + txnAmt + " to " + custName, confirmedTrade);

		} else {
			mapData = new HashMap<>();
			mapData.put("trade not found with id " + tradeId, findById);

		}
		return mapData;
	}

	@Override
	public Trade getTradeById(int tradeId) {
		Trade findTrade = repository.findById(tradeId).get();

		return findTrade;
	}

	// to remove trade if
	@Override
	public boolean deleteTrade(int tradeId) {
		Trade findById = repository.findById(tradeId).get();
		if (!findById.isBooked() && findById != null) {
			repository.delete(findById);
			return true;
		}
		return false;
	}

	@Override
	public List<Trade> getAllTrades() {
		List<Trade> findAll = repository.findAll();
		return findAll;
	}

	@Override
	public Trade updateTrade(Trade trade, int tradeId) {

		Trade tradeById = repository.findById(tradeId).get();
		tradeById.setCustomerName(trade.getCustomerName());
		tradeById.setCurrencyPair(trade.getCurrencyPair());
		tradeById.setAmountToTransfer(trade.getAmountToTransfer());
		Trade updatedTrade = repository.save(tradeById);
		return updatedTrade;
	}

}