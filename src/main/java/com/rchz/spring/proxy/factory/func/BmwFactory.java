package com.rchz.spring.proxy.factory.func;

import com.rchz.spring.proxy.factory.Bmw;
import com.rchz.spring.proxy.factory.Car;

public class BmwFactory implements Factory {
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
