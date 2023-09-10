package com.finzly.fxtrading.services;

import java.util.List;
import java.util.Map;

import com.finzly.fxtrading.entities.Trade;

public interface TradeServices {

	// to create new trade
	Trade createNewFxTrade(Trade trade);

	// to confirm created trade
	Map<String, Trade> confirmNewFxTrade(int tradeId);

	// to get trade using trade id
	Trade getTradeById(int tradeId);

	// to delete a unconfirmed trade
	boolean deleteTrade(int tradeId);

	// to get all the trades
	List<Trade> getAllTrades();

	// to update trade data
	Trade updateTrade(Trade trade, int tradeId);

}