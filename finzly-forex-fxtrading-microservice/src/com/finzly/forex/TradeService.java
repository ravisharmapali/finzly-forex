package com.finzly.forex;

import java.util.List;
import java.util.Scanner;

public class TradeService {

	public static void bookTrade(List<Trade> trades) {

		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		String customerName = "";
		String currencyPair = "";
		String amount;
		do {
			System.out.println("Enter Customer Name ");
			customerName = sc.nextLine();
			if (customerName.equals(null) || customerName.trim().equals("")) {
				System.err.println("customer name cant be blank! enter cancel and try again!");
//				continue;

			}

			System.out.println("Enter Currency Pair ");
			currencyPair = sc.nextLine();

			System.out.println("Enter Amount to transfer ");
			amount = sc.nextLine();
		} while (!flag);

		double amountToTransfer = Double.parseDouble(sc.nextLine());

		// validate user data
//		int amountToTransfer = TradeUtil.validateTradeData(customerName, currencyPair, amount);

		// System.out.println("Do you want to get Rate ");
//		boolean getRate = sc.nextBoolean();

		// creating trade
		Trade trade = new Trade();
		trade.setTradeNo(trades.size() + 1);
		trade.setCustomerName(customerName);
		trade.setCurrencyPair(currencyPair);
		trade.setAmount(amountToTransfer);

		if (amountToTransfer != 0) {
			trade.setConvertedAmount(amountToTransfer);

			System.out.println(
					"You are transferring INR " + trade.getConvertedAmount() + " to " + trade.getCustomerName());
			System.out.println("Book/Cancel this trade?");
		}

		boolean flag2 = false;
		do {
			String bookOrCancel = sc.nextLine();
			if (bookOrCancel.equalsIgnoreCase("book")) {
				System.out.println(
						"Trade for " + trade.getCurrencyPair() + " has been booked with rate " + trade.getRate()

								+ " The amount of Rs " + trade.getConvertedAmount()
								+ " will  be transferred in 2 working days to " + trade.getCustomerName() + ".");
				// adding
				trades.add(trade);
				flag2 = true;
			} else if (bookOrCancel.equalsIgnoreCase("cancel")) {
				System.out.println("Trade is Canceled. ");
				flag2 = true;
			} else {
				System.out.println("please enter book/cancel");
				flag2 = false;
			}
		} while (!flag2);

	}

	public static void printTrades(List<Trade> trades) {

		if (trades.size() == 0) {
			System.out.println("no trades found!");
		} else {

			System.out.println("TradeNo CurrencyPair CustomerName Amount   Rate ");
			for (int i = 0; i < trades.size(); i++) {
				System.out.println(trades.get(i));
			}
		}
	}

	public static boolean exitTrade() {

		System.out.println("Do you really want to exit (y/n)");
		Scanner sc = new Scanner(System.in);
		String exitState = sc.next().substring(0, 1);

		if (exitState.equalsIgnoreCase("y")) {
			System.out.println("Bye - have a good day");
			return true;
		} else if (exitState.equalsIgnoreCase("n")) {
			return false;
		} else {
			System.out.println("Please enter value in valid format");
		}
		return false;

	}

	public static int validateUserInput(String userInput) {
		int inputValue = 0;
		try {
			inputValue = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			System.out.println("Please enter valid num value");
		}
		return inputValue;
	}

}