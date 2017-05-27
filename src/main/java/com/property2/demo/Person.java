package com.property2.demo;

/**
 * Created by Administrator on 2017/5/27.
 */
public class Person {
    private String name;
    private int age;

    public Person() {
        name = null;
        age = 0;
    }

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
