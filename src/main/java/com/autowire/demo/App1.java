package com.autowire.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/25.
 */
public class App1 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com.autowire.demo/beans.xml");
        Person p = (Person) ac.getBean("Robin");
        System.out.println(p.getName() + " has a " + p.getDog().getName());
    }
}
