package com.challenge.caleta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.challenge.caleta")
public class CaletaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaletaApplication.class, args);
	}

}