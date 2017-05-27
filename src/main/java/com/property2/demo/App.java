package com.property2.demo;


import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/27.
 */
public class App {


    /**
     * Created by Administrator on 2017/5/26.
     */

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com.property2.demo/beans.xml");
        Person pp;

        pp = (Person) ac.getBean("person");
        System.out.println("person " + pp.getName() + " with age " + pp.getAge());

        for (String name: ac.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

}
