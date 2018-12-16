package com.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		// Tell Boot to look for registration-server.yml
	    System.setProperty("spring.config.name", "registration-server");
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
