package org.example.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * Bean 初始化顺序 @PostConstruct -> InitializingBean -> 自定义方法 initUserFactory
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月19日 15:49:00
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct : UserFactory 初始化中..");
    }

    public void initUserFactory(){
        System.out.println("自定义方法 initUserFactory() : UserFactory 初始化中..");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet() : UserFactory 初始化中..");
    }

    //-------销毁

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy() 销毁中....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBeanPreDestroy#destroy() 销毁中....");
    }

    public void doDestroy(){
        System.out.println("自定义方法 doDestroy() 销毁中....");
    }

    @Override
    protected void finalize(){
        System.out.println("当前 DefaultUserFactory 正在被回收.....");
    }
}
