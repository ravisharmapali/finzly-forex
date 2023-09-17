package com.finzly.fxtrading.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Currency {

	@Id
	private String currencyPair;
	private double currencyRate;

	public Currency() {

	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}

	@Override
	public String toString() {
		return "Currency [currencyPair=" + currencyPair + ", currencyRate=" + currencyRate + "]";
	}

}
