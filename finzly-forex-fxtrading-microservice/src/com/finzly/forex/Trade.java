package com.finzly.forex;

public class Trade {

	private int tradeNo;
	private String currencyPair;
	private String customerName;
	private double amount;
	private double rate;
	private double convertedAmount;

//	private Converter converter;

	public Trade() {

		tradeNo = 0;
		this.currencyPair = "";
		this.customerName = "";
		this.amount = 00.00;
		this.rate = Converter.RATE;
//		this.converter = new Converter();
	}

	public int getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(int tradeNo) {

		this.tradeNo = tradeNo;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double amount) {
		// setting converted amount
		this.convertedAmount = Converter.convert(amount);
	}

//	public Converter getConverter() {
//		return converter;
//	}
//
//	public void setConverter(Converter converter) {
//		this.converter = converter;
//	}

	@Override
	public String toString() {
		return tradeNo + "\t " + currencyPair.toUpperCase() + "\t " + customerName + "\t " + "INR"
				+ Converter.convert(amount) + "\t " + rate;
	}

}