package com.rchz.spring.proxy.factory.abstr;

import com.rchz.spring.proxy.factory.Benc;
import com.rchz.spring.proxy.factory.Car;

public class BencAbsFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new Benc();
    }
}
