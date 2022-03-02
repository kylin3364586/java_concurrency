package com.rchz.spring.proxy.dynamic;

import com.rchz.spring.proxy.stat1.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {

    private Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    //获取代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    //执行被代理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}
