package com.aop.cglib.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2017/5/30.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ServiceConfig.class);
        MyService pp;

        pp = (MyService) ac.getBean("myService");

        pp.perform();

        for (String name : ac.getBeanDefinitionNames()) {
            System.out.println("name " + name);
        }
    }
}
