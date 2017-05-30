### demo实现

在业务函数有入参时，切面程序捕获入参和不捕获入参的实现方式, 修改切点表达式。

1. 编写业务程序
```java
package com.aop.args.demo;
public interface Service {
    public void perform(String name);
}

@Component
public class MyService implements Service {

    public void perform(String name) {
        System.out.println("exec perform!!!" + name);
    }
}
```

2. 编写切面程序
```java
package com.aop.args.demo;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class MyLogger {
    @Before("execution(* com.aop.args.demo.Service.perform(String)) && args(name)")
    void writeLog1(String name) {
        System.out.println("Pre perform exec with arg " + name);
    }

    @After("execution(* com.aop.args.demo.Service.perform(**))")
    void writeLog2() {
        System.out.println("Post perform exec");
    }
}
```

3. 编写config程序
```java
package com.aop.args.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ServiceConfig {
    @Bean
    public MyLogger getMyLogger() {
        return new MyLogger();
    }
}
```

4. App.java实现
```java
package com.aop.args.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2017/5/30.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ServiceConfig.class);
        Service pp;

        pp = (Service) ac.getBean("myService");

        pp.perform("Robin");

        for (String name : ac.getBeanDefinitionNames()) {
            System.out.println("name " + name);
        }
    }
}
```

4. 添加jar包
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
```
