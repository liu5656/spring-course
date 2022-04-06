package org.example.reflact;

/**
 * @version 1.0
 * @Author lj
 * @date 2021/7/20 3:48 下午
 * @desc
 */
public class Person {
    private int age = 20;
    protected String sex;
    public String name;

    private void doingSomeThing() {
        System.out.println(this.name + "is doing something");
    }

    public void sayHiTo(String name) {
        System.out.println(this.name + "say hi to " + name);
    }
}
