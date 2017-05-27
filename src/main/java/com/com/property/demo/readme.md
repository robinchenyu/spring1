## Spring学习使用Property注解注入值

1. @PropertySource("classpath:/com/soundsystem/app.properties")注解添加property bean
2. @Autowired获取property bean，赋值到Environment env变量上
3. env.getProperty("key") 获取取值

### 测试demo

实现一个类，拥有name属性，通过property注入赋值
```java
// 添加person类，拥有name属性
package com.com.property.demo;

/**
 * Created by Administrator on 2017/5/26.
 */
public class Person {
    private String name;
    private int age;

    public Person(String property, int property1) {
        this.name = property;
        this.age = property1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

```

实现javaconfig，添加@PropertySource
```java
// 添加JavaConfig类，并显示实现bean的构造
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

```

实现测试代码，获取Person的bean, 进行调用测试
```java
// App.java
package com.com.property.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Administrator on 2017/5/26.
 */

public class App1 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person pp;

        pp = (Person) ac.getBean("person");

        System.out.println("person " + pp.getName() + " with age " + pp.getAge());
    }
}

```

添加com.property.demo/app.properties配置文件
```ini
person.name=xiaoming
person.age=18
```

疑问: 为什么PropertySource注解不产生一个bean?

