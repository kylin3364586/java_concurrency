package org.example.thinking.in.spring.ioc.overview.dependency.injection;

import org.example.thinking.in.spring.ioc.overview.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月06日 17:05:00
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置XML 配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:\\META-INF\\dependency-injection-context.xml");
        UserRepository bean = beanFactory.getBean(UserRepository.class);
        System.out.println(bean.toString());

    }


}
