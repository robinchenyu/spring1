package com.aop.args.demo;


import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/30.
 */
@Component
public class MyService implements Service {
    public void perform(String name) {
        System.out.println("exec perform!!!" + name);
    }
}
