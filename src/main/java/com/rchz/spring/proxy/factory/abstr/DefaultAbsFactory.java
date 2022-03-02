package com.rchz.spring.proxy.factory.abstr;

import com.rchz.spring.proxy.factory.Car;

public class DefaultAbsFactory extends AbstractFactory{

    AudiAbsFactory audiAbsFactory = new AudiAbsFactory();


    @Override
    public Car getCar() {
        return audiAbsFactory.getCar();
    }
}
