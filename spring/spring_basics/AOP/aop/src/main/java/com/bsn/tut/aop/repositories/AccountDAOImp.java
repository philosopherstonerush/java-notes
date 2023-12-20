package com.bsn.tut.aop.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImp implements AccountDAO{
    public void addAccount() {
        System.out.println(getClass() + " ADDING ACCOUNT");
    }
}
