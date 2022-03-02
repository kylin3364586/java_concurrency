package com.rchz.spring.proxy.cglib;

public class Test {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getInterceptor();

        //执行代理对象的方法
        proxy.print();
    }
}
