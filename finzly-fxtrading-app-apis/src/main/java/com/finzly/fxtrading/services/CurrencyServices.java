package com.finzly.fxtrading.services;

import com.finzly.fxtrading.entities.Currency;

public interface CurrencyServices {
	String createNewCurrency(Currency currency);
	String getCurrencyPair(String currencyPair);
	String updateCurrencyRate(String currencyPair, double rate);
}