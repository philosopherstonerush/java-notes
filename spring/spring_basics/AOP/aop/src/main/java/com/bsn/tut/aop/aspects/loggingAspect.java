package com.bsn.tut.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingAspect {

    // BEFORE EXECUTION of the method of this signature, do this
    @Before("execution(public void addAccount())")
    public void beforeAddAccount(){
        System.out.println("\n=======> DICKKKKK BEFOREEEE");
    }

}
