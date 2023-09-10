package com.finzly.fxtrading.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtrading.entities.Trade;
import com.finzly.fxtrading.services.TradeServices;

/**
 * 
 * 
 * @apiNote Provides functionalities related to fx trading below endpoints sends
 *          response using {@link ResponseEntity} with {@link HttpStatusCode}
 * @author Ravi Sharma
 */

@RestController
@RequestMapping("/api/v1")
public class TradeController {

	@Autowired
	TradeServices tradeServices;

	/**
	 * Create a new trade initially
	 * 
	 * @param Trade from request body
	 * @return the created trade with status code
	 */
	@PostMapping("/trade")
	public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {
		Trade createdTrade = tradeServices.createNewFxTrade(trade);

		return new ResponseEntity<>(createdTrade, HttpStatus.CREATED);
	}

	/**
	 * Book newly created trade after getting confirmation
	 * 
	 * @return the confirmed created trade with status code
	 */
	@GetMapping("/trade/confirm/{tradeId}")
	public ResponseEntity<Map<String, Trade>> bookConfirmTrade(@PathVariable int tradeId) {
		Map<String, Trade> createdTrade = tradeServices.confirmNewFxTrade(tradeId);

		return new ResponseEntity<>(createdTrade, HttpStatus.CREATED);
	}

	/**
	 * to get(print) the trade
	 * 
	 * @param id of the trade to find
	 * @return the trade if it is found with status
	 */
	@GetMapping("/trade/{tradeId}")
	public ResponseEntity<Trade> findTradeById(@PathVariable int tradeId) {
		Trade tradeById = tradeServices.getTradeById(tradeId);
		return new ResponseEntity<>(tradeById, HttpStatus.FOUND);
	}

	/**
	 * to cancel unbooked trade
	 * 
	 * @param id of the trade to find and remove trade
	 * @return response that Trade is deleted or not
	 */
	// cancel trade
	@DeleteMapping("/trade/{tradeId}")
	public ResponseEntity<Map<String, Boolean>> cancelTrade(@PathVariable int tradeId) {
		boolean deleted = false;
		deleted = tradeServices.deleteTrade(tradeId);
		Map<String, Boolean> response;
		if (deleted) {
			response = new HashMap<>();
			response.put("Deleted", deleted);
		} else {
			response = new HashMap<>();
			response.put("Unable to delete", deleted);
		}
		return ResponseEntity.ok(response);

	}

	/**
	 * to get all the trades
	 * 
	 * @return the list of trades
	 */
	@GetMapping("/trades")
	public ResponseEntity<List<Trade>> getAllTrades() {
		List<Trade> allTrades = tradeServices.getAllTrades();
		return new ResponseEntity<>(allTrades, HttpStatus.OK);
	}

	/**
	 * to update the trade details before confirmation
	 */

	@PutMapping("/trade/{tradeId}")
	public ResponseEntity<Trade> updateTrade(@RequestBody Trade trade, @PathVariable int tradeId) {

		Trade updateTrade = tradeServices.updateTrade(trade, tradeId);
		return new ResponseEntity<>(updateTrade, HttpStatus.OK);

	}

}