package com.rchz.spring.proxy.factory.abstr;

import com.rchz.spring.proxy.factory.Audi;
import com.rchz.spring.proxy.factory.Benc;
import com.rchz.spring.proxy.factory.Bmw;
import com.rchz.spring.proxy.factory.Car;

public abstract class AbstractFactory {

    protected abstract Car getCar();

    public Car getCar(String name){
        if("bmw".equalsIgnoreCase(name)){
            return new Bmw();
        }else if("audi".equalsIgnoreCase(name)){
            return new Audi();
        }else if("benc".equalsIgnoreCase(name)){
            return new Benc();
        }else{
            return null;
        }
    }
}
