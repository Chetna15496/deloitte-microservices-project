package com.deloitte.currency.exchange.service.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ExchangeRateNotFoundException extends RuntimeException {
	public ExchangeRateNotFoundException(String msg) {
		super(msg);
	}
}
