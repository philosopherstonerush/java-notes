package com.bsn.tut.aop.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImp implements AccountDAO{
    public void addAccount() {
        System.out.println(getClass() + " ADDING ACCOUNT");
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
}
