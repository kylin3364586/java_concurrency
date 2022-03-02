package com.rchz.spring.proxy.factory.abstr;

import com.rchz.spring.proxy.factory.Bmw;
import com.rchz.spring.proxy.factory.Car;

public class BmwAbsFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
