package org.example.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("myStudent")
public class Student {
//    @Autowired
//    public Student(School school) {
//        this.school = school;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    @Value("28")
    private int age;
    @Value("nimo")
    private String name;
    @Autowired
    @Qualifier("mySchool")
    private School school;

    @Resource
    private School mySchool;

    public Student() {
        System.out.println("Student 的无参构造方法");
    }
    public Student(String name, int age, School school) {
        System.out.println("Student的有参构造方法");
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public void setSchool(School school) {
        System.out.println("setSchool:" + school);
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", school=" + school +
                '}';
    }
}
