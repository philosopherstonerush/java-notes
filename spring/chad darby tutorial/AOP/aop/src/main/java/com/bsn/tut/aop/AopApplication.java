package com.bsn.tut.aop;

import com.bsn.tut.aop.repositories.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return runner -> {
			addAccountExample(accountDAO);
		};
	}

	public void addAccountExample(AccountDAO accountDAO){
		accountDAO.addAccount();
	}

}
