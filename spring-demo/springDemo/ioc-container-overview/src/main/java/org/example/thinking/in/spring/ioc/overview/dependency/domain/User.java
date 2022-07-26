package org.example.thinking.in.spring.ioc.overview.dependency.domain;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月06日 17:13:00
 */
public class User {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static User createUser(){
        User user = new User();
        user.setId(1L);
        user.setName("111");
        return user;
    }
}
