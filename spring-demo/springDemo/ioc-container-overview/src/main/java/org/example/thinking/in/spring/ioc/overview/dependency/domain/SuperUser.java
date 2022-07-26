package org.example.thinking.in.spring.ioc.overview.dependency.domain;

import org.example.thinking.in.spring.ioc.overview.dependency.annotation.Super;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月06日 17:46:00
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
