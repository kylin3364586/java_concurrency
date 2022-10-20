package com.jike.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 反射测试类
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月20日 15:04:00
 */
public class ReflectTest {

    /**
     * 获取类对象
     * @throws ClassNotFoundException
     */
    @Test
    public void test1() throws ClassNotFoundException {
        //获取字节码对象的三种方式
        Class<?> aClass1 = Class.forName("com.jike.reflection.Student");
        Class<Student> aClass2 = Student.class;
        Class<? extends Student> aClass3 = new Student().getClass();

        //获取字节码对象
        System.out.println(aClass1);
        //获取完整类名
        System.out.println(aClass1.getName());
        //获取类型
        System.out.println(aClass1.getSimpleName());
        //获取包名称
        System.out.println(aClass1.getPackage());
        //获取包路径名称
        System.out.println(aClass1.getPackage().getName());

    }

    /**
     * 获取成员变量
     */
    @Test
    public void test2(){
        Student student1 = new Student("张三", 3);
        Student student2 = new Student("李四", 4);
        Student student3 = new Student("王五", 5);

        Student[] students = {student1, student2, student3};
        System.out.println(Arrays.toString(students));

        for (Student s: students) {
            s.play();
            System.out.println(s.age);
        }
    }

    /**
     * 获取字段
     * @throws ClassNotFoundException
     */
    @Test
    public void test3() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.jike.reflection.Student");
        Field[] fields = aClass.getFields();
        for (Field f: fields) {
            System.out.println(f.getName());
            System.out.println(f.getType());

        }
    }

    /**
     * 获取成员方法
     * @throws ClassNotFoundException
     */
    @Test
    public void test4() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.jike.reflection.Student");
        Method[] methods = aClass.getMethods();
        for (Method f: methods) {
            System.out.println(f);
            System.out.println(f.getName());
            Class<?>[] parameterTypes = f.getParameterTypes();
            System.out.println(Arrays.toString(parameterTypes));
        }
    }

    /**
     * 获取构造方法
     */
    @Test
    public void test5() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.jike.reflection.Student");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
            System.out.println("方法名称："+ c.getName());
            Class[] parameterTypes = c.getParameterTypes();
            System.out.println(Arrays.toString(parameterTypes));
        }
    }

}
