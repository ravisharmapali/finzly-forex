package com.finzly.fxtrading.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtrading.entities.Currency;
import com.finzly.fxtrading.services.CurrencyServiceImpl;

@RestController
@RequestMapping("/api/currency/")
public class CurrencyController {

	@Autowired
	private CurrencyServiceImpl currencyService;

	@PostMapping("/")
	public ResponseEntity<?> createNewCurrency(@RequestBody Currency currency) {
		String status = currencyService.createNewCurrency(currency);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/{currencyPair}")
	public ResponseEntity<?> getCurrencyPair(@PathVariable String currencyPair) {
		String pair = currencyService.getCurrencyPair(currencyPair);
		return new ResponseEntity<>(pair, HttpStatus.FOUND);
	}

	@PutMapping("/{currencyPair}")
	public ResponseEntity<?> updateCurrencyRate(@PathVariable String currencyPair, @RequestParam double rate) {
		String rate2 = currencyService.updateCurrencyRate(currencyPair, rate);
		return new ResponseEntity<>(rate2, HttpStatus.OK);

	}

}