package com.chad.jpatutorial.CRUDapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruDappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDappApplication.class, args);
	}

	// CommandLineRunner - one of the ways to implement it

	@Bean
	public CommandLineRunner commandLineRunner (String[] args) {
		return runner -> {
			System.out.println("Hello World");
		};
	}
}
