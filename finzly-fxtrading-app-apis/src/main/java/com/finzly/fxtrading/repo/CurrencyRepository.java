package com.finzly.fxtrading.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxtrading.entities.Currency;

@Repository
public class CurrencyRepository {

	@Autowired
	private SessionFactory factory;

	public String createNewCurrency(Currency currency) {
		Session session = factory.openSession();

		session.save(currency);
		session.beginTransaction().commit();
		session.close();

		return "New Currency Created";
	}

	public String getCurrencyPair(String currencyPair) {
		Session session = factory.openSession();
		Currency currency = session.get(Currency.class, currencyPair);
		return currency.getCurrencyPair();
	}

	public String updateCurrencyRate(String currencyPair, double rate) {
		Session session = factory.openSession();
		Currency currency = session.get(Currency.class, currencyPair);
		if (currency != null) {
			currency.setCurrencyRate(rate);
			return "rate updated";
		} else {
			return "unable to update , no currencypair found";
		}

	}

}