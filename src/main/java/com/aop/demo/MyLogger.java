package com.aop.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Administrator on 2017/5/30.
 */
@Aspect
public class MyLogger {
    @Before("execution(* com.aop.demo.Service.perform(..))")
    public void writeLog1() {
        System.out.println("pre perform logs");
    }

    @After("execution(* com.aop.demo.Service.perform(..))")
    public void writeLog2() {
        System.out.println("post perform logs");
    }
}
