package com.bsn.tut.aop.repositories;

public interface AccountDAO {
    void addAccount();
    void updateAccount();
    void addFakeAccount();
    void countAccounts();
    int countAccountsInt();
}
