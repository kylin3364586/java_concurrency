package com.rchz.spring.proxy.stat1;

public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void remove() {
        log("remove");
        userService.remove();
    }

    public void log(String method){
        System.out.println("{info} 调用方法" + method);
    }
}
