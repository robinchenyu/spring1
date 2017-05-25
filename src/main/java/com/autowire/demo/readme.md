### autowire分为下面几种选项

1. byName - 根据成员变量名查找相同名字的bean obj
2. byType - 根据成员类型查找相同类型的bean obj
3. constructor - 根据构造函数初始化bean, 赋值bean obj
4. default - no 不做自动装载

### demo代码

创建一个person和dog, person拥有成员变量dog。
```java
package com.autowire.demo;

/**
 * Created by Administrator on 2017/5/25.
 */
public class Person {
    private String name;
    private int age;
    private Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```
```java
package com.autowire.demo;

/**
 * Created by Administrator on 2017/5/25.
 */
public class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

2. 配置beans.xml装载

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
    <bean id="Robin" class="com.autowire.demo.Person" autowire="byName" p:name="Chen" p:age="31"/>
    <bean id="dog" class="com.autowire.demo.Dog" p:name="wan"/>

</beans>
```

byName在查找bean配置中的id="dog"是区分大小写的, 如果修改为id="Dog", 或者id="dog1", 均会报错。
如果配置autowire="constructor", 则会查找Person(Dog dog)构造函数构造Person bean.

3. 添加测试代码

```java
package com.autowire.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/25.
 */
public class App1 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com.autowire.demo/beans.xml");
        Person p = (Person) ac.getBean("Robin");
        System.out.println(p.getName() + " has a " + p.getDog().getName());
    }
}
```