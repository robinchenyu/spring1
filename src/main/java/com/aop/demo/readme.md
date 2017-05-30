### aop的基本概念
#### 通知 (Advice) - 定义附加的操作或步骤

Advice有以下五种模式:
1. before
2. after
3. around
4. after-returning
5. after-throwing

#### 连接点(Join Point)

Advice植入的位置， 可以认为在业务程序插入的位置。

#### 切点(Pointcut)

Join Point的集合，通常以正则表达式描述连接点的位置；定义插入位置的表达式。

#### 切面(Aspect)

Advice和Pointcut的集合，通过切面定义要做的事情；定义插入程序的操作。

### Spring对AOP支持的情况

1. 基于代理的经典Spring AOP
2. 纯POJO切面
3. @AspectJ注解驱动的切面
4. 注入式AspectJ切面

前3中是Spring AOP实现的变体，Spring AOP构建在动态代理基础之上，仅限于方法拦截。

### 注解方式aop实现要点

1. 定义切面程序，需要使用@Aspect注解class
2. 在切面程序方法前，注解Advice以及切点表达式
3. 在config中，定义注解的扫描以及注解的Bean生成函数

#### demo实现

1. 编写业务程序
```java
package com.aop.demo;
public interface Service {
    public void perform();
}

@Component
public class MyService implements Service {

    public void perform() {
        System.out.Println("exec perform!!!");
    }
}
```

2. 编写切面程序
```java
package com.aop.demo;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class MyLogger {
    @Before("execution(* com.aop.demo.Service.perform(**))")
    void writeLog1() {
        System.out.Println("Pre perform exec");
    }

    @After("execution(* com.aop.demo.Service.perform(**))")
    void writeLog2() {
        System.out.Println("Post perform exec");
    }
}
```

3. 编写config程序
```java
package com.aop.demo;

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

测试:
1. MyService作为普通POJO进行调用，是否会有aop注入
2. MyService作为一个Bean被调用，是否会有aop注入
3. 如果截获的业务函数有入参，怎么在切面程序中获取到入参的取值
4. 针对一个class做为业务类，学习如何使用GClib