package org.example.thinking.in.spring.lifecycle;

import java.util.Optional;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年09月21日 15:45:00
 */
public class Test {
    public static void main(String[] args) throws Exception {
        User user = new User();
        if (user != null) {
            Address address = user.getAddress();
            if(address != null){
                System.out.println(address.getCity());
            }
        }

        Optional.ofNullable(user)
                .map(u -> user.getAddress())
                .map(a -> a.getCity())
                .orElseThrow(()->new Exception("取值错误"));

    }
}


class User{
    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
class Address{
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
