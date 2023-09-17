package com.finzly.fxtrading.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * Entity class representing Trade
 **/

@Entity
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tradeId;

	private String customerName;

	private String currencyPair;

	private double amountToTransfer;
//
//	@OneToOne
//	private Currency currency;
	// property to checked the trade is booked or not
	private boolean isBooked = false;

	public Trade() {

	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAmountToTransfer() {
		return amountToTransfer;
	}

	public void setAmountToTransfer(double amountToTransfer) {
		this.amountToTransfer = amountToTransfer;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", customerName=" + customerName + ", currencyPair=" + currencyPair
				+ ", amountToTransfer=" + amountToTransfer + ", isBooked=" + isBooked + "]";
	}

}