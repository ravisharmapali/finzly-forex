package com.finzly.fxtrading.entities;


import com.finzly.fxtrading.config.AppConstant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Entity class representing Trade
 **/
@Entity
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tradeId;
	
	@NotEmpty
	@Size(min = 3, message = "Customer Name must be min of 3 characters !!")
	private String customerName;
	
	@NotEmpty
	private String currencyPair;
	
	@NotEmpty
	private double amountToTransfer;
	// initialize trade rate
	private double tradeRate = AppConstant.TRADE_RATE;
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

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getAmountToTransfer() {
		return amountToTransfer;
	}

	public void setAmountToTransfer(double amountToTransfer) {
		this.amountToTransfer = amountToTransfer;
	}

	public double getTradeRate() {
		return tradeRate;
	}

	public void setTradeRate(double tradeRate) {
		this.tradeRate = tradeRate;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", customerName=" + customerName + ", currencyPair=" + currencyPair
				+ ", amountToTransfer=" + amountToTransfer + ", tradeRate=" + tradeRate + "]";
	}

}