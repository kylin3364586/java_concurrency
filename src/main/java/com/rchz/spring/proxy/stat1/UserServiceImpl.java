package com.rchz.spring.proxy.stat1;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add 方法");
    }

    @Override
    public void remove() {
        System.out.println("remove 方法");
    }
}
