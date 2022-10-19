package com.jike.jdk5;

/**
 * 泛型接口
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月19日 16:47:00
 */
public interface GenericsInterfaceDemo<T> {
    public T next();
}

class A<String> implements GenericsInterfaceDemo<String>{
    @Override
    public String next() {
        return null;
    }
}

class B<T> implements GenericsInterfaceDemo<T>{

    @Override
    public T next() {
        return null;
    }
}

class C implements GenericsInterfaceDemo<Object>{

    @Override
    public Object next() {
        return null;
    }
}
