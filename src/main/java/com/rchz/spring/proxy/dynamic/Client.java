package com.rchz.spring.proxy.dynamic;

import com.rchz.spring.proxy.stat1.UserService;
import com.rchz.spring.proxy.stat1.UserServiceImpl;

/**
 * 动态代理
 * @description
 * @author kylin
 * @date 2021/8/23 10:55
 **/
public class Client {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        ProxyInvocationHandler proxy = new ProxyInvocationHandler();
        proxy.setObj(userService);

        UserService userService1 = (UserService) proxy.getProxy();
        userService1.add();
    }
}
