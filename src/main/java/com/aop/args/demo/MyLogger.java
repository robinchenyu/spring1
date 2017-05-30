package com.aop.args.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Administrator on 2017/5/30.
 */
@Aspect
public class MyLogger {
    @Before("execution(* com.aop.args.demo.Service.perform(String)) && args(name)")
    void writeLog1(String name) {
        System.out.println("Pre perform exec with arg " + name);
    }

    @After("execution(* com.aop.args.demo.Service.perform(**))")
    void writeLog2() {
        System.out.println("Post perform exec");
    }
}
