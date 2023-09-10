package com.finzly.fxtrading.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finzly.fxtrading.entities.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {

}