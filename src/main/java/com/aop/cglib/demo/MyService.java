package com.aop.cglib.demo;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/30.
 */
@Component
public class MyService {
    public void perform() {
        System.out.println("exec perform() cglib");
    }
}
