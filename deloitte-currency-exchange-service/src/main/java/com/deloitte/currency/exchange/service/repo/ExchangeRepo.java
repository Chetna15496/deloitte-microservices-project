package com.deloitte.currency.exchange.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deloitte.currency.exchange.service.model.ExchangeRate;


public interface ExchangeRepo extends JpaRepository<ExchangeRate,Integer>{

		@Query("from ExchangeRate where fromCur=:fromCur and toCur=:toCur")
		ExchangeRate findByfromCurAndtoCur(String fromCur,String toCur);
}
