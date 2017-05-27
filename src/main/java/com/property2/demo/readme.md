## Spring学习使用Property注解注入值

1. 在xml配置文件中添加property文件路径
```java
<context:property-placeholder location="classpath:com.property2.demo/app.properties"/>
```
2. 在xml配置bean时，使用${key}格式获取数据进行配置

### 测试demo

实现一个类，拥有name属性，通过property注入赋值
```java
// 添加person类，拥有name属性
package com.com.property2.demo;

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

    public Person() {
        name = null;
        age = 0;
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
        ApplicationContext ac = new ClassPathXmlApplicationContext("com.property2.demo/beans.xml");
        Person pp;

        pp = (Person) ac.getBean("person");

        System.out.println("person " + pp.getName() + " with age " + pp.getAge());
    }
}

```

实现beans.xml配置
```xml
<?xml version="1.0" encoding="utf-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:c="http://www.springframework.org/schema/c"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd">
    <context:property-placeholder location="com.property2.demo/app.properties"/>

    <bean id="Robin" class="com.autowire.demo.Person" p:name="${person.name}" p:age="${person.age}"/>
    <!-- <bean id="dog" class="com.autowire.demo.Dog" p:name="${dog.name}"/> -->

</beans>
```

添加com.property.demo/app.properties配置文件
```ini
person.name=xiaoming
person.age=18
```

测试: xml注解的property-placeholder会否产生bean obj
会产生一个org.springframework.context.support.PropertySourcesPlaceholderConfigurer#0 的bean obj

