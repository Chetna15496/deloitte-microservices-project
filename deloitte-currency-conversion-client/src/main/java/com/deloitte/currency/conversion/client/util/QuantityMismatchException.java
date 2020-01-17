package com.deloitte.currency.conversion.client.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class QuantityMismatchException extends RuntimeException {
	public QuantityMismatchException(String msg) {
		super(msg);
	}
}
