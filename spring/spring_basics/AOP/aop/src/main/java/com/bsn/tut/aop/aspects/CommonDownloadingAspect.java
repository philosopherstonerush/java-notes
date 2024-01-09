package com.bsn.tut.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// @Aspect is optional if there is no @Before or advices and this class has only pointcut expressions
@Aspect
@Component
public class CommonDownloadingAspect {
    @Pointcut("execution(* downloading* ())")
    public void forDownloading(){};
}
