package org.example.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * {@link BeanCreationExceptionDemo} 演示
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月26日 10:29:00
 */
class BeanCreationExceptionDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 BeanDefinition Class 是一个 POJO 普通类，初始化抛出异常
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
        applicationContext.registerBeanDefinition("errBean", beanDefinitionBuilder.getBeanDefinition());
        //启动 Spring应用上下文
        applicationContext.refresh();

        //关闭 Spring应用上下文
        applicationContext.close();
    }

    static class POJO implements InitializingBean{

        @PostConstruct
        public void init() throws Exception{
            throw new Exception("For purposes...");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("For purposes...");
        }
    }


}
