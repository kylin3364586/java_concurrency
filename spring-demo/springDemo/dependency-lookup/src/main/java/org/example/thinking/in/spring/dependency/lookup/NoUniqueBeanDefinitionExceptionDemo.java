package org.example.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link NoUniqueBeanDefinitionException} 演示
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月26日 10:29:00
 */
public class NoUniqueBeanDefinitionExceptionDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前 ObjectProviderDemo 作为配置类
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);
        //启动 Spring应用上下文
        applicationContext.refresh();

        try {
            //由于Spring应用上下文存在3个String类型的bean,通过单一类型查找会抛出异常
            applicationContext.getBean(String.class);
        }catch (NoUniqueBeanDefinitionException e){
            System.err.printf("由于Spring应用上下文存在%d个%s类型的bean，具体原因：%s",e.getNumberOfBeansFound(), String.class.getName(), e.getMessage());
        }


        //关闭 Spring应用上下文
        applicationContext.close();
    }

    @Bean
    private String bean1(){
        return "1";
    }
    @Bean
    private String bean2(){
        return "2";
    }
    @Bean
    private String bean3(){
        return "3";
    }
}
