package com.bsn.tut.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DownloadingLinuxAspect {

    @Before("com.bsn.tut.aop.aspects.CommonDownloadingAspect.forDownloading()")
    public void forDownloadingLinux() {
        System.out.println("OI LINUX");
    }

}
