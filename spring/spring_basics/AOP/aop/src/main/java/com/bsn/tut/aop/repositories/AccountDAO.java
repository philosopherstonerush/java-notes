package com.bsn.tut.aop.repositories;

import com.bsn.tut.aop.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(String a);
    void updateAccount();
    void addFakeAccount();
    void countAccounts();
    int countAccountsInt();
    void declareWar();
    void declarePeace();
    List<Account> findAccounts();
}
