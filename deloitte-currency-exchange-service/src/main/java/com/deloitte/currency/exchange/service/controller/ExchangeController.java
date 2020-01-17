package com.deloitte.currency.exchange.service.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.currency.exchange.service.model.ExchangeRate;
import com.deloitte.currency.exchange.service.repo.ExchangeRepo;

import com.deloitte.currency.exchange.service.util.ExchangeRateNotFoundException;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
//	@Autowired
//	ExchangeService service;
	@Autowired
	ExchangeRepo repo;
	@Autowired
	Environment env;
	ResponseEntity<ExchangeRate> re;
	@GetMapping("/from/{from}/to/{to}")
	public ResponseEntity<ExchangeRate> getExchangeRate(@PathVariable("from")String from,@PathVariable("to")String to)
	{
		try {
		int port=Integer.parseInt(env.getProperty("local.server.port"));
    	ExchangeRate eRate=repo.findByfromCurAndtoCur(from,to);
		System.out.println("hi");
//		ExchangeRate eRate=service.findByfromCurAndtoCur(from,to);
		if(eRate==null)
		{
			return new ResponseEntity<ExchangeRate>(HttpStatus.NOT_FOUND);
		}
		eRate.setPort(port);
		return new ResponseEntity<ExchangeRate>(eRate,HttpStatus.OK);
		}
		catch(ExchangeRateNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/getall")
	public List<ExchangeRate> getAll(){
		
		
		return repo.findAll();
	}
	
}
