package com.kk.kylinstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-09- 11:24:00
 */
//指定从配置文件中加载属性的前缀
@ConfigurationProperties(prefix = "kylin")
public class KylinProperties {

    private String name = "curry";
    private Integer age = 22;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "KylinProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
