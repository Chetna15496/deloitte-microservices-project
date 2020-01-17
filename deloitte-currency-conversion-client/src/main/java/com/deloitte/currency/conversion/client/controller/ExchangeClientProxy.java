package com.deloitte.currency.conversion.client.controller;

import java.util.List;


import org.springframework.cloud.netflix.ribbon.RibbonClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.deloitte.currency.conversion.client.model.ExchangeRate;


@FeignClient(value="deloitte-currency-conversion-service")
@RibbonClient(value="deloitte-currency-conversion-service")
public interface ExchangeClientProxy {

	@GetMapping("/convert-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<ExchangeRate> getConvertedValue(@PathVariable("from")String from,@PathVariable("to")String to,@PathVariable("quantity")float quantity);
	@GetMapping("/allcurrencies")
	public List<ExchangeRate> getAllCurrencies();
}
