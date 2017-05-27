package com.com.property.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by Administrator on 2017/5/26.
 */
@Configuration
@PropertySource("classpath:com.property.demo/app.properties")
public class PersonConfig {
    @Autowired
    Environment env;

    @Bean
    public Person person() {
        return new Person(env.getProperty("person.name"),
                Integer.parseInt(env.getProperty("person.age")));
    }
}
