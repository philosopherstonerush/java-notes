package com.bsn.tut.aop.aspects;

import com.bsn.tut.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class loggingAspect {


    // After Returning Advice
    // It is important that the string value for returning matches with the parameter.
    @AfterReturning(
        pointcut = "execution(* com.bsn.tut.aop.repositories.AccountDAO.findAccounts(..))",
        returning = "result"
    )
    public void log_account_method_and_result(JoinPoint theJoinPoint, List<Account> result) {
        for(Account elem: result) {
            System.out.println("AFTER RETURNING + " + elem);
        }
    }


    // A point declaration follows the exact syntax.
    // Use the method name to refer to this pointcut expression
    @Pointcut("execution(* declare* (..))")
    private void declareAnything() {}; // mind this empty body

    @Before("declareAnything()")
    public void beforeDeclareWar() {
        System.out.println("AAAAAAAAA");
    }

    @Before("declareAnything()")
    public void beforeDeclarePeace() {
        System.out.println("BBBBBBBBB");
    }

    // Want to include that start with declare but not also declareWar?

    @Pointcut("execution(* declareWar* (..))")
    private void forMethodsWithDeclareWar(){};

    @Before("declareAnything() && !(forMethodsWithDeclareWar())")
    public void forMethodsthatAreDeclareButNotDeclareWar() {{
        System.out.println("NOOO WARRRR");
    }}

    // BEFORE EXECUTION of the method of this signature, do this
    // This matches with any class that has the same method.
    @Before("execution(public void addAccount(..))")
    public void beforeAddAccount(JoinPoint joinPoint){

        // Jointpoint to access method parameters and signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args_for_method = joinPoint.getArgs();

        for(Object temp: args_for_method) {
            // This String can be replaced with an entity and you could be use entity specific methods
            if(temp instanceof String) {
                temp = (String) temp;
                System.out.println("argument " + temp);
            }
        }
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
