package com.deloitte.currency.conversion.client;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.deloitte.currency.conversion.client.controller")
public class DeloitteCurrencyConversionClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeloitteCurrencyConversionClientApplication.class, args);
	}

}
