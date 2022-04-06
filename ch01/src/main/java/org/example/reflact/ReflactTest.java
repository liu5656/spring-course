package org.example.reflact;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Author lj
 * @date 2021/7/20 3:50 下午
 * @desc
 */
public class ReflactTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "zhangsan";
        Class<?> reflect = personClass(person);

        // 只能获取public限定的属性
        for (Field fie : reflect.getFields()) {
            System.out.println("field: " + fie.getName());
        }
        System.out.println("--------------------------getFields---------------------------");

        // 获取所有属性
        for (Field fie : reflect.getDeclaredFields()) {
            System.out.println("declared field: " + fie.getName());
        }
        System.out.println("--------------------------getDeclaredFields---------------------------");
        // 通过反射修改变量
        try{
            Field field = reflect.getDeclaredField("age");
            field.setAccessible(true);  // 只有被private修饰的属性才需要
            int age = field.getInt(person);
            System.out.println(person.name + "' age is " + age + " before modified");
            field.setInt(person, 18);
            System.out.println(person.name + "' age is " + field.getInt(person) + " after modified");
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------修改private修饰的变量---------------------------\n\n");


        // 只能获取public限定的方法
        for (Method method : reflect.getMethods()) {
            System.out.println("method: " + method.getName());
        }
        System.out.println("--------------------------getMethods---------------------------");

        // 获取所有的方法
        for (Method method : reflect.getDeclaredMethods()) {
            System.out.println("declared method: " + method.getName());
        }
        System.out.println("--------------------------getDeclaredMethods---------------------------");

        // 通过反射调用方法
        try{
            Method sayHi = reflect.getDeclaredMethod("sayHiTo", String.class);
//            sayHi.setAccessible();    // 只有被private修饰的方法才需要
            sayHi.invoke(person, "lisi");
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------通过反射调用方法---------------------------");
    }

    public static Class<?> personClass(Person per) {
//        方法1
        Class<? extends Person> res = per.getClass();
        return res;

//        方法2
//        Class<Person> res = Person.class;
//        return res;

//        方法3
//        try{
//            Class<?> res = Class.forName("senior.reflection.Person");
//            return res;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
    }

}
