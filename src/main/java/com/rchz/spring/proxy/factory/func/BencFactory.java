package com.rchz.spring.proxy.factory.func;

import com.rchz.spring.proxy.factory.Benc;
import com.rchz.spring.proxy.factory.Car;

public class BencFactory implements Factory {
    @Override
    public Car getCar() {
        return new Benc();
    }
}
