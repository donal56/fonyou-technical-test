package com.example.fonyou.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.fonyou"})
public class FonYouApplication {

	public static void main(String[] args) {
		SpringApplication.run(FonYouApplication.class, args);
	}

}
