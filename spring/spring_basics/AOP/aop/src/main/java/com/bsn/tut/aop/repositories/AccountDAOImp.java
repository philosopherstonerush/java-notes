package com.bsn.tut.aop.repositories;

import com.bsn.tut.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImp implements AccountDAO{
    public void addAccount(String a) {
        System.out.println(getClass() + " ADDING ACCOUNT" + a);
    }

    @Override
    public void updateAccount() {
        System.out.println(getClass() + " UPDATING ACCOUNT");
    }

    @Override
    public void addFakeAccount() {
        System.out.println(getClass() + " FAKING ACCOUNT");
    }

    @Override
    public void countAccounts() {
        System.out.println(getClass() + " void COUNT ACCOUNT");
    }

    @Override
    public int countAccountsInt() {
        System.out.println(getClass() + " Int COUNT ACCOUNT");
        return 1;
    }

    @Override
    public void declareWar() {
        System.out.println("DIE MOTHERFUCKER");
    }

    @Override
    public void declarePeace() {
        System.out.println("PEACE OUT BRO");
    }

    @Override
    public List<Account> findAccounts() {

        ArrayList<Account> accounts = new ArrayList<>();

        Account a1 = new Account("suvarna", 18);
        Account a2 = new Account("meena", 20);

        accounts.add(a1);
        accounts.add(a2);

        return accounts;

    }
}
