package org.example.thinking.in.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * 实现
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年09月19日 17:05:00
 */
class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())){
            UserHolder userHolder = (UserHolder)bean;
            userHolder.setDescription("The user holder V9");
            System.out.println("afterPropertiesSet() = " + userHolder.getDescription());
        }
    }
}
