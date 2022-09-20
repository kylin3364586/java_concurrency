package org.example.thinking.in.spring.lifecycle;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.SuperUser;
import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年09月19日 17:05:00
 */
class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)){
            // 把配置完成的 superUser Bean 覆盖
            return new SuperUser();
        }
        return null;// 保持 Spring Ioc 容器实例化操作
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())){
            //手动赋值
            User user = (User)bean;
            user.setId(3L);
            user.setName("kylin");
            // "user" 对象不允许属性赋值（填入） （配置元信息 —> 属性值）
            return false;
        }
        return true;
    }

    //user 是跳过 Bean 属性赋值（填入）
    //superUser 完全跳过 Bean 实例化（Bean 属性赋值（填入））
    //userHolder
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws  BeansException{
        // 对 "userHolder" Bean 进行拦截
        if(ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())){
            // 假设<property name="number" value="1"/>配置的话，那么在 PropertyValue 就包含一个 PropertyValue(number = 1)

            final MutablePropertyValues propertyValues;

            if(pvs instanceof MutablePropertyValues){
                propertyValues = (MutablePropertyValues) pvs;
            }else{
                propertyValues = new MutablePropertyValues();
            }

            // 等价于 <property name="number" value="1"/>
            propertyValues.addPropertyValue("number", "1");

            //如果存在 "description" 属性配置的话
            if(propertyValues.contains("description")){
                //PropertyValues value 是不可变的
                propertyValues.removePropertyValue("description");
                propertyValues.addPropertyValue("description","The user holder V2");
            }
            return propertyValues;
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())){
            UserHolder userHolder = (UserHolder)bean;
            userHolder.setDescription("The user holder V3");
        }
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())){
            UserHolder userHolder = (UserHolder)bean;
            userHolder.setDescription("The user holder V7");
        }
        return bean;
    }
}
