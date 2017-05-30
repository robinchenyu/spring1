### cglib的aop demo实现

当业务实现不为接口，而是一个class时，需要引入cglib。

1. 编写业务程序
```java
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
```

2. 编写切面程序
```java
package com.aop.cglib.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Administrator on 2017/5/30.
 */
@Aspect
public class MyLogger {
    @Before("execution(* com.aop.cglib.demo.MyService.perform(..))")
    public void writeLog1() {
        System.out.println("pre perform logs cglib");
    }

    @After("execution(* com.aop.cglib.demo.MyService.perform(..))")
    public void writeLog2() {
        System.out.println("post perform logs cglib");
    }
}
```

3. 编写config程序
```java
package com.aop.cglib.demo;

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
    public MyLogger mylogger() {
        return new MyLogger();
    }

}

```

4. 编写App.java
```java
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
```

5. 添加jar包
```xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjrt -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.8.10</version>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.8.10</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>4.3.8.RELEASE</version>
</dependency>
<!-- https://mvnrepository.com/artifact/cglib/cglib -->
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.2.5</version>
</dependency>
```
