package com.deloitte.currency.conversion.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.deloitte.currency.conversion.service.model.ConversionBean;



@RestController
public class ConversionController {
	
	@Autowired
	RestTemplate rt;
	
	@GetMapping("/convert/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<ConversionBean> getConvertedValue(@PathVariable("from")String from,@PathVariable("to")String to,@PathVariable("quantity")float quantity)
	{
		ResponseEntity<ConversionBean> cbResponse=rt.getForEntity("http://localhost:8000/exchange/from/"+from+"/to/"+to,ConversionBean.class);
		if(cbResponse.getStatusCodeValue()==200)
		{
		ConversionBean cb=cbResponse.getBody();
		float total=quantity*cb.getExchangeValue();
		cb.setQuantity(quantity);
		cb.setTotal(total);
		return new ResponseEntity<ConversionBean>(cb,HttpStatus.OK);
		}
		return new ResponseEntity<ConversionBean>(HttpStatus.NOT_FOUND);
	}
	
}
