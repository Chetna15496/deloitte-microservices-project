package com.deloitte.currency.conversion.client.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deloitte.currency.conversion.client.model.ExchangeRate;



@Controller

public class CurrencyController {

	@Autowired
	ExchangeClientProxy proxy;
	
//	@Autowired
//	Environment env;
	//ResponseEntity<ExchangeRate> re;
	@GetMapping("/convertproduct")
	public String getfromCur(Model m){
		List<ExchangeRate> eRate=proxy.getAllCurrencies();
		List<String> fromList=new ArrayList();
		for(ExchangeRate e:eRate) {
			fromList.add(e.getFromCur());
		}
		List<String> toList=new ArrayList();
		for(ExchangeRate e:eRate) {
			toList.add(e.getToCur());
		}
		m.addAttribute("to",new HashSet<String>(toList));
		m.addAttribute("from",new HashSet<String>(fromList));
		return "convertproduct.jsp";
	}
	
 }
