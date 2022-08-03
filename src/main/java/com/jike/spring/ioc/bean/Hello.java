package com.jike.spring.ioc.bean;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年05月07日 16:56:00
 */
public class Hello {

    private String helloMsg;

    public Hello() {
        System.out.println("hello 注入到spring IOC容器种");
    }

    public void setContent(String helloMsg) {
        this.helloMsg = helloMsg;
    }

}
