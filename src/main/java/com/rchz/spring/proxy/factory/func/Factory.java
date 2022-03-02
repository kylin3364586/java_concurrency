package com.rchz.spring.proxy.factory.func;

import com.rchz.spring.proxy.factory.Car;

//工厂接口，定义所有工厂执行标准
public interface Factory {

    Car getCar();
}
