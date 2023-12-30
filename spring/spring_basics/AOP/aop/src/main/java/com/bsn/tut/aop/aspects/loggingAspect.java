package com.bsn.tut.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingAspect {

    // BEFORE EXECUTION of the method of this signature, do this
    // This matches with any class that has the same method.
    @Before("execution(public void addAccount())")
    public void beforeAddAccount(){
        System.out.println("\n=======> DICKKKKK BEFOREEEE");
    }

    // This will only match that specific class
    @Before("execution(public void com.bsn.tut.aop.repositories.AccountDAO.updateAccount())")
    public void beforeUpdateAccount() {
        System.out.println("\n=======> UPDATEEEEE BEFOREEEE");
    }

    // Wildcards to match with any method name that starts with add
    @Before("execution(public void add* ())")
    public void beforeFakingAccount(){
        System.out.println("\n=======> FAKEEEE BEFOREEEE");
    }

    //public is optional
    @Before("execution(* count* ())")
    public void beforeCountingAccounts() {
        System.out.println("\n=======> Counting BEFOREEEE");
    }

}
