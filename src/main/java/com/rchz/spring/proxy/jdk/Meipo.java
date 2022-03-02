package com.rchz.spring.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//媒婆,代理
public class Meipo implements InvocationHandler {

    private Person person;//代理类

    public Object getInstance(Person person){
        this.person = person;

        Class c = person.getClass();
        System.out.println("被代理对象："+c);
        //loader–定义代理类的类加载器
        //interfaces–要实现的代理类的接口列表
        //h–将方法调用分派到的调用处理程序
        Object o = Proxy.newProxyInstance(c.getClassLoader(), c.getInterfaces(), this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("筛选");
        person.findLove();
        return null;
    }
}
