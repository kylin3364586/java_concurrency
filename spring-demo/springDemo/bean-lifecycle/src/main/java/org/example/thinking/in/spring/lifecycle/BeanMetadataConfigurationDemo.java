package org.example.thinking.in.spring.lifecycle;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * Bean 元信息配置示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月17日 16:03:00
 */
public class BeanMetadataConfigurationDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //实例化基于Properties 资源 BeanDefinitionReader
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        String location = "META-INF\\user.properties";
        //加载 Properties 资源
        Resource resource = new ClassPathResource(location);
        //指定字符编码 UTF-8
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println(beanNumbers);

        //通过 Bean Id 和类型进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}
