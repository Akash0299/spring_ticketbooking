package com.ltts.demoapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoapplicationApplication.class, args);
	}

}
