package com.finzly.fxtrading.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtrading.entities.Trade;
import com.finzly.fxtrading.excecption.ResourceNotFoundException;
import com.finzly.fxtrading.repo.TradeRepository;

/**
 * service implementations for Trade contains business logic
 */
@Service
public class TradeServicesImpl implements TradeServices {

	// service method takes help of repository for various db related
	// operations.
	@Autowired
	private TradeRepository repository;

	@Autowired
	private CurrencyServices currencyServices;

	/**
	 * creates new fx trade takes trade as argument
	 */
	@Override
	public Trade createNewFxTrade(Trade trade) {
		trade.setBooked(false);

		String currencyPair = trade.getCurrencyPair();
		String foundPair = currencyServices.getCurrencyPair(currencyPair);
		if (foundPair != null) {
			Trade savedTrade = repository.createNewFxTrade(trade);
			return savedTrade;
		} else {
			throw new ResourceNotFoundException("currency pair", currencyPair, 0);
		}

	}

	/**
	 * confirmNewFxTrade method will take trade id and set the booked trade as
	 * confirm .
	 */
	@Override
	public Map<String, Trade> confirmNewFxTrade(int tradeId) {
		return repository.confirmNewFxTrade(tradeId);

	}

	@Override
	public Trade getTradeById(int tradeId) {
		return repository.getTradeById(tradeId);

	}

	// to remove trade if
	@Override
	public boolean deleteTrade(int tradeId) {
		return repository.deleteTrade(tradeId);
	}

	@Override
	public List<Trade> getAllTrades() {
		List<Trade> allTrades = repository.getAllTrades();

		return allTrades;
	}

	@Override
	public Trade updateTrade(Trade trade, int tradeId) {
		return repository.updateTrade(trade, tradeId);

	}

}