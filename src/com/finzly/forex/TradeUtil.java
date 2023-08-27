package com.finzly.forex;

public class TradeUtil {

	public static boolean validateInputOption(String str) {
		try {
			int val = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.err.println("Please enter valid numeric value ");
			return false;
		}

		return true;
	}

	public static int validateTradeData(String customerName, String currencyPair, String amount) {
		int amountToTransfer = 0;
		if (customerName.equals(null) || customerName.trim().equals("")) {

//			String regex = ".*\\d.*";
//
//			Pattern pattern = Pattern.compile(regex);
//			Matcher matcher = pattern.matcher(customerName);
//			if(matcher.matches()) {
//				System.err.println("Invalid name ");
//			}

			System.err.println("customer name cant be blank! enter cancel and try again!");

			return 0;
		}
		if (!currencyPair.trim().equalsIgnoreCase("usdinr")) {
			System.err.println("only USDINR is allowd in currency pair");
		}
		if (!amount.equals(null) || !amount.trim().equals("")) {

			try {
				amountToTransfer = Integer.parseInt(amount);
				if (amountToTransfer < 1) {
					System.out.println("min amount 1$");
				}
			} catch (NumberFormatException e) {
				System.err.println("enter num value only!");
			}
		}
		return amountToTransfer;
	}

}