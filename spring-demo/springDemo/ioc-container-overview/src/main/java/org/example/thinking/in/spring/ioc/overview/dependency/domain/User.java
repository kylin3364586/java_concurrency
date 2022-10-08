package org.example.thinking.in.spring.ioc.overview.dependency.domain;

import org.example.thinking.in.spring.ioc.overview.dependency.enums.City;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月06日 17:13:00
 */
public class User implements BeanNameAware {

    private Long id;
    private String name;
    private City city;
    private City[] workerCity;
    private List<City> lifeCity;
    private Resource configFileLocation;
    private transient String beanName;//当前Bean的名称


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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Resource getConfigFileLocation() {
        return configFileLocation;
    }

    public void setConfigFileLocation(Resource configFileLocation) {
        this.configFileLocation = configFileLocation;
    }

    public City[] getWorkerCity() {
        return workerCity;
    }

    public void setWorkerCity(City[] workerCity) {
        this.workerCity = workerCity;
    }

    public List<City> getLifeCity() {
        return lifeCity;
    }

    public void setLifeCity(List<City> lifeCity) {
        this.lifeCity = lifeCity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workerCity=" + Arrays.toString(workerCity) +
                ", lifeCity=" + lifeCity +
                ", configFileLocation=" + configFileLocation +
                '}';
    }

    public static User createUser(){
        User user = new User();
        user.setId(1L);
        user.setName("111");
        return user;
    }

    @PostConstruct
    public void inti(){
        System.out.println("用户 Bean ["+ beanName +"] 初始化...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("用户 Bean ["+ beanName +"] 销毁中...");
    }

    @Override
    public void setBeanName(String name) {

        this.beanName = name;
    }
}
