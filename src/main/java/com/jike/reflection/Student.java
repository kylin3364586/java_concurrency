package com.jike.reflection;

/**
 *  反射测试物料类
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月20日 15:00:00
 */
public class Student {

    private String name;
    public int age;

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

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void play(){
        System.out.println("不玩游戏，学Java！");
    }
    public void sunDay(int n){
        System.out.println("卷起来！"+ n);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
