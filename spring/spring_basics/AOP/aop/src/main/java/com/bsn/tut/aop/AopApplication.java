package com.bsn.tut.aop;

import com.bsn.tut.aop.logic.Downloader;
import com.bsn.tut.aop.repositories.AccountDAO;
import com.bsn.tut.aop.service.FortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, Downloader d, FortuneService fs) {
		return runner -> {
//			addAccountExample(accountDAO);
//			updateAccountExample(accountDAO);
//			fakeAccountExample(accountDAO);
//			countingAccountExample(accountDAO);
//			declaration_exmaple(accountDAO);
//			execute_download(d);
//			after_returning_advice_getting_list_of_accounts(accountDAO);
//			after_throwing_exception(accountDAO);
//			after_finally_logging(accountDAO);
			around_advice(fs);
		};
	}

	private void around_advice(FortuneService fs) {

		fs.todays_fortune();

	}

	private void after_finally_logging(AccountDAO accountDAO) {

		System.out.println("IN MAIN");
		accountDAO.findAccountsEvenWithOrWithoutException(false);

	}

	private void after_throwing_exception(AccountDAO accountDAO) {

		System.out.println("IN MAIN");
		accountDAO.findAccountsButThrowException();

	}


	private void after_returning_advice_getting_list_of_accounts(AccountDAO accountDAO) {

		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("IN MAIN");

		for(Account elem: accounts) {
			System.out.println(elem);
		}

	}

	private void execute_download(Downloader d) {
		d.downloadingLinux();
		d.downloadingWindows();
	}


	private void declaration_exmaple(AccountDAO accountDAO) {
		accountDAO.declareWar();
		accountDAO.declarePeace();
	}

	private void countingAccountExample(AccountDAO accountDAO) {
		accountDAO.countAccounts();
		accountDAO.countAccountsInt();
	}

	public void addAccountExample(AccountDAO accountDAO){
		accountDAO.addAccount("suvarna");
	}

	public void updateAccountExample(AccountDAO accountDAO) {
		accountDAO.updateAccount();
	}

	public void fakeAccountExample(AccountDAO accountDAO) {
		accountDAO.addFakeAccount();
	}

}
