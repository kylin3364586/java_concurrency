package org.example.thinking.in.spring.ioc.overview.dependency.container;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * {@link BeanFactory} 作为 Ioc 容器示例
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月14日 14:23:00
 */
public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //加载配置
        int loadBeanDefinitions = reader.loadBeanDefinitions("classpath:\\META-INF\\dependency-lookup-context.xml");
        System.out.println("Bean 定义加载的数量：" + loadBeanDefinitions);
        //依赖查找集合对象
        lookupCollectionByType(beanFactory);

    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            Map<String, User> beansOfType = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("根据类型查找集合bean:" +beansOfType);
        }
    }
}
