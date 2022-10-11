package org.example.thinking.in.spring.configuration.metadata;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * {@link PropertiesBeanDefinitionReader} 示例
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月10日 17:09:00
 */
public class PropertiesBeanDefinitionReaderDemo {

    public static void main(String[] args) {
        // 创建 Ioc 底层容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建面向 Properties 资源的 BeanDefinitionReader 示例
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        // Properties 资源加载默认通过 ISO-8859-1, 实际存储 UTF-8
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        // 通过指定ClassPath 获取 Resource 对象
        Resource resource = resourceLoader.getResource("classpath:\\META-INF\\user-bean-definitions.properties");
        // 转换成带有字符编码 EncodedResource 对象
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        int definitions = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println(String.format("已加载 %s 个 BeanDefinition \n", definitions));
        // 通过依赖查找获取 UserBean
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}
