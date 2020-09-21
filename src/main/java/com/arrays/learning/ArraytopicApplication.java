package com.arrays.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArraytopicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArraytopicApplication.class, args);
		
		SpringApplication app = new SpringApplication(ArraytopicApplication.class);
		app.setAdditionalProfiles(System.getProperty("APP_ENV", "dev"));
		app.run(args);
	}

}
