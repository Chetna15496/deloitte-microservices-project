package com.deloitte.currency.conversion.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DeloitteNetflixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeloitteNetflixEurekaServerApplication.class, args);
	}

}
