package com.hospify.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospifyApplication.class, args);
		System.out.println("Hospify Project started");
	}

}
