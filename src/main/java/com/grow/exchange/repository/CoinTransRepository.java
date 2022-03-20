package com.grow.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grow.exchange.entity.CoinTransactionLog;

@Repository
public interface CoinTransRepository extends JpaRepository<CoinTransactionLog, Long>{
	
	 
	
	}