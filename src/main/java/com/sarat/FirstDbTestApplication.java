package com.sarat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sarat.controller.EmpController;

@SpringBootApplication
public class FirstDbTestApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(EmpController.class);

	public static void main(String[] args) {
		SpringApplication.run(FirstDbTestApplication.class, args);
		System.out.println("Welcome to SpringBoot Project..");
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}

}
