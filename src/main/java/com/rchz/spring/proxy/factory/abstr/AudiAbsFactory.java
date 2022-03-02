package com.rchz.spring.proxy.factory.abstr;

import com.rchz.spring.proxy.factory.Audi;
import com.rchz.spring.proxy.factory.Car;

public class AudiAbsFactory extends AbstractFactory  {

    @Override
    public Car getCar() {
        return new Audi();
    }
}
