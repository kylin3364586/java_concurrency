package org.example.thinking.in.spring.ioc.overview.dependency.injection;

import org.example.thinking.in.spring.ioc.overview.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 * 有多少种依赖注入方式？
 * 1.构造器注入       用于：少依赖、强制依赖
 * 2.Setter注入      用于：多依赖、非强制依赖
 * 3.字段注入        开发比较便利
 * 4.方法注入        主要做声明、例如@Bean
 * 5.接口回调注入     生命周期回调
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
