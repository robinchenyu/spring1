package com.autowire.demo;

/**
 * Created by Administrator on 2017/5/25.
 */
public class Person {
    private String name;
    private int age;
    private Dog dog;

    public Person(Dog dog) {
        this.dog = dog;
    }

    public Person(String name, int age, Dog dog) {
        System.out.println("call Person");
        this.name = name;
        this.age = age;
        this.dog = dog;
    }

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
