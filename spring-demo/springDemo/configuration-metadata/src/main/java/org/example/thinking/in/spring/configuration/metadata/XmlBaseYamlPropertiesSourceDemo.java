package org.example.thinking.in.spring.configuration.metadata;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 *  基于 Java 注解的 YAML 外部化配置示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月24日 11:03:00
 */
public class XmlBaseYamlPropertiesSourceDemo {
    public static void main(String[] args) {
        // 创建 Ioc 底层容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建 XML 资源的 BeanDefinitionReader
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 加载 XMl 资源
        reader.loadBeanDefinitions("classpath:/META-INF/yaml-property-source-context.xml");
        // 获取 Map YAML 对象
        Map<String, Object> ymlMap = beanFactory.getBean("yamlMap", Map.class);
        System.out.println(ymlMap);
    }
}
