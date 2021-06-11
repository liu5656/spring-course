package org.example;

import org.example.service.service.SomeService;
import org.example.service.service.Student;
import org.example.service.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public  void test01() {
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    @Test
    public void test02() {
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
         SomeService service = (SomeService) ac.getBean("someService");
         service.doSome();
    }

    @Test
    public void test03() {
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student jack = (Student) ac.getBean("myStudent");
        System.out.println(jack.toString());

        Student erwa = (Student)ac.getBean("myStudent2");
        System.out.println(erwa.toString());
    }

    @Test
    public void test04() {
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        System.out.println(ac.getBeanDefinitionCount());
        for (String name : ac.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
    @Test
    public  void test05() {
        String config = "beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
    }
}
