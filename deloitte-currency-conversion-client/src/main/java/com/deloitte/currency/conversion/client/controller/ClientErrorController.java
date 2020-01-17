package com.deloitte.currency.conversion.client.controller;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.deloitte.currency.conversion.client.util.ErrorResponse;
import com.deloitte.currency.conversion.client.util.QuantityMismatchException;
//import com.deloitte.currency.exchange.service.util.ExchangeRateNotFoundException;


@RestController
@ControllerAdvice
public class ClientErrorController extends ResponseEntityExceptionHandler{
	  @ExceptionHandler(QuantityMismatchException.class)
		public  ResponseEntity<ErrorResponse> handleNotFoundError(Exception ex,WebRequest req){
			ErrorResponse response=new ErrorResponse(new Date(), ex.getMessage(), req.getDescription(false));
			return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
	}

		

		@ExceptionHandler(Exception.class)
	  public  ResponseEntity<ErrorResponse> handleAllError(Exception ex,WebRequest req){
			ErrorResponse response=new ErrorResponse(new Date(), ex.getMessage(), req.getDescription(false));
			return new ResponseEntity<ErrorResponse>(response,HttpStatus.BAD_REQUEST);
		}

}
