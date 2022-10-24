package org.example.thinking.in.spring.configuration.metadata;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Spring XML 元素扩展示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月11日 17:16:00
 */
public class ExtensibleXmlAuthoringDemo {

    public static void main(String[] args) {
        // 创建 Ioc 底层容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建 XML 资源的 BeanDefinitionReader
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 加载 XMl 资源
        reader.loadBeanDefinitions("META-INF/user-context.xml");
        // 获取 User Bean 对象
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }
}
