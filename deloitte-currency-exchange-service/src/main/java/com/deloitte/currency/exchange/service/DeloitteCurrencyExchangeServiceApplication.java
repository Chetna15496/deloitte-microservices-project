package com.deloitte.currency.exchange.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DeloitteCurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeloitteCurrencyExchangeServiceApplication.class, args);
	}

}
