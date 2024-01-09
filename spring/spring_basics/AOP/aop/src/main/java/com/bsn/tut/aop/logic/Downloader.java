package com.bsn.tut.aop.logic;

import org.springframework.stereotype.Component;

@Component
public class Downloader {
    public void downloadingLinux() {
        System.out.println("Downloaded in Linux");
    }

    public void downloadingWindows() {
        System.out.println("Downloaded in Windows");
    }
}
