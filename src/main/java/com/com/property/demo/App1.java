package com.com.property.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Administrator on 2017/5/26.
 */

public class App1 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person pp;

        pp = (Person) ac.getBean("person");

        System.out.println("person " + pp.getName() + " with age " + pp.getAge());

        for (String name : ac.getBeanDefinitionNames()) {
            System.out.println("name " + name);
        }
    }
}
