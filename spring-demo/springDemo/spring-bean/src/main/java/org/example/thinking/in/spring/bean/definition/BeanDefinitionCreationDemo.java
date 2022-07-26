package org.example.thinking.in.spring.bean.definition;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月14日 16:58:00
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        // 1.通过BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //设置属性
        beanDefinitionBuilder.addPropertyValue("id",2);
        beanDefinitionBuilder.addPropertyValue("name","kk");
        //获取 BeanDefinition
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        // 2.通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置bean类型
        genericBeanDefinition.setBeanClass(User.class);
        //通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("id",3).add("name","curry");
        beanDefinition.setPropertyValues(mutablePropertyValues);

    }
}
