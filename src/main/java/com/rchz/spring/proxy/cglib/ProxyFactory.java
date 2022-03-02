package com.rchz.spring.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    private Object obj;

    public ProxyFactory(Object obj) {
        this.obj = obj;
    }

    public Object getInterceptor(){
        Enhancer ne = new Enhancer();
        ne.setSuperclass(obj.getClass());
        ne.setCallback(this);
        return ne.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理类执行");
        Object o1 = method.invoke(obj,objects);
        return o1;
    }
}
