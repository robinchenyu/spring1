package com.aop.args.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Administrator on 2017/5/30.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ServiceConfig {
    @Bean
    public MyLogger getMyLogger() {
        return new MyLogger();
    }
}
