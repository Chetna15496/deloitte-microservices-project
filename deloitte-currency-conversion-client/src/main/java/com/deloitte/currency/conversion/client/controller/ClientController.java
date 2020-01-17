package com.deloitte.currency.conversion.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import com.deloitte.currency.conversion.client.controller.ExchangeClientProxy;

import com.deloitte.currency.conversion.client.model.ExchangeRate;
import com.deloitte.currency.conversion.client.util.QuantityMismatchException;



@Controller
public class ClientController {
	@Autowired
	ExchangeClientProxy proxy;
	
	@GetMapping("/convert")
	public String getConvertValue(@RequestParam("from")String from,@RequestParam("to")String to,@RequestParam("quantity")float quantity,Model m) 
	{
		
		ResponseEntity<ExchangeRate> cbResponse=proxy.getConvertedValue(from,to,quantity);
		
		ExchangeRate cb=cbResponse.getBody();
		//cb.setQuantity(quantity);
		float total=cb.getTotal();
		
		System.out.println("Hello");
		System.out.println(cb);
		System.out.println(total);
		String str="";
		if(to.equals("INR"))
		{
			str="RS";
		}
		else if(to.equals("USD"))
		{
			str="$";
		}
		else if(to.equals("EUR"))
		{
			str="Euro";
		}
		m.addAttribute("str",str);
		m.addAttribute("id",total);
		System.out.println(str);
//		float total=quantity*cb.getExchangeValue();
//		cb.setQuantity(quantity);
//		cb.setTotal(total);
		return "final.jsp";
	}
	
}