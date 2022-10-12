package org.example.thinking.in.spring.configuration.metadata;

import org.springframework.beans.factory.xml.NamespaceHandler;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 *
 * users.xsd {@link  NamespaceHandler} 实现
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年10月11日 16:37:00
 */
public class UsersNamespaceHandler extends NamespaceHandlerSupport {


    @Override
    public void init() {
        // 将 user 元素注册对应的 BeanDefinitionParser 实现
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
