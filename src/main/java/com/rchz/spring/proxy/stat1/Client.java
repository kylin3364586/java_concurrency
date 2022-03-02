package com.rchz.spring.proxy.stat1;

/**
 * 静态代理
 * @description
 * @author kylin
 * @date 2021/8/23 10:54
 **/
public class Client {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.remove();
    }
}
