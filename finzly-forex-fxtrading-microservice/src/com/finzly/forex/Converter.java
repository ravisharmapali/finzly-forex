package com.finzly.forex;

// class to provide conversion of usd to inr

public abstract class Converter {
	
	public static final double RATE = 82.55;
	
	public static double convert(double amount) {
        return amount * RATE;
    }
}
