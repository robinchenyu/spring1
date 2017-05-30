package com.aop.xml.demo;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/30.
 */
public class MyService implements Service {
    public void perform() {
        System.out.println("exec perform() xml");
    }
}
