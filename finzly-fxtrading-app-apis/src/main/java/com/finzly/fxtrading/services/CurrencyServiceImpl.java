package com.finzly.fxtrading.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtrading.entities.Currency;
import com.finzly.fxtrading.repo.CurrencyRepository;

@Service
public class CurrencyServiceImpl implements CurrencyServices {

	@Autowired
	private CurrencyRepository currencyRepo;

	public String createNewCurrency(Currency currency) {
		String newCurrency = currencyRepo.createNewCurrency(currency);

		return newCurrency;
	}

	public String getCurrencyPair(String currencyPair) {
		String cPair = currencyRepo.getCurrencyPair(currencyPair);
		return cPair;
	}

	@Override
	public String updateCurrencyRate(String currencyPair, double rate) {
		String status = currencyRepo.updateCurrencyRate(currencyPair, rate);
		return status;
	}

}