package com.rchz.spring.proxy.factory.func;

import com.rchz.spring.proxy.factory.Audi;
import com.rchz.spring.proxy.factory.Car;

public class AudiFactory implements Factory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
