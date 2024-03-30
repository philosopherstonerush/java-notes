package com.hypersrot.assignment.demo;

import com.hypersrot.assignment.demo.entity.Coupon;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
