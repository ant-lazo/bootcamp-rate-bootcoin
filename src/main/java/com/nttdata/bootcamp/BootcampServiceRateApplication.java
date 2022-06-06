package com.nttdata.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BootcampServiceRateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampServiceRateApplication.class, args);
	}

}
