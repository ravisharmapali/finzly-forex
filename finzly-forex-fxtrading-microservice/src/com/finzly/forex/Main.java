package com.finzly.forex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	// list of trades to store trades
	private static List<Trade> trades = new ArrayList<Trade>();
	// to terminate the loop
	private static boolean flag = false;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("\nWelcome to Finzly Forex\n");

		do {
			System.out.println("\nl Book Trade - 1");
			System.out.println("l Print Trades - 2");
			System.out.println("l Exit - 3");
			System.out.println("Please enter the number to select the option");
			String input = scanner.nextLine();

			if (TradeUtil.validateInputOption(input)) {
				int a = Integer.valueOf(input);

				switch (a) {
				case 1:
					TradeService.bookTrade(trades);
//					System.out.println("check");
					break;
				case 2:
					TradeService.printTrades(trades);
					break;
				case 3:
					flag = TradeService.exitTrade();
					break;
				default:
					System.out.println("Please select valid option");
				}
			}

		} while (!flag);

	}

}