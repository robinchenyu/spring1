### demo实现

1. 编写业务程序
```java
package com.aop.xml.demo;
public interface Service {
    public void perform();
}


public class MyService implements Service {

    public void perform() {
        System.out.Println("exec perform!!! xml");
    }
}
```

2. 编写切面程序
```java
package com.aop.xml.demo;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class MyLogger {
    @Before("execution(* com.aop.xml.demo.Service.perform(..))")
    public void writeLog1() {
        System.out.println("pre perform logs xml");
    }

    @After("execution(* com.aop.xml.demo.Service.perform(..))")
    public void writeLog2() {
        System.out.println("post perform logs xml");
    }
}
```

3. 编写config程序

需要添加域名
```xml
xmlns:aop="http://www.springframework.org/schema/aop"
 xsi:schemaLocation="
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd"
```

```xml
<?xml version="1.0" encoding="utf-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:c="http://www.springframework.org/schema/c"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd">
    <aop:aspectj-autoproxy />

    <bean id="myService" class="com.aop.xml.demo.MyService" />
    <!-- Aspect -->
    <bean id="myLogger" class="com.aop.xml.demo.MyLogger" />


</beans>
```

4. 编写App
```java
package com.aop.xml.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/30.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com.aop.xml.demo/beans.xml");
        Service pp;

        pp = (Service) ac.getBean("myService");

        pp.perform();

//        for (String name : ac.getBeanDefinitionNames()) {
//            System.out.println("name " + name);
//        }
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
```