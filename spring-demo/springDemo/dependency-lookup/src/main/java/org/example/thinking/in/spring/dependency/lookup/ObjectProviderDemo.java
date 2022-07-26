package org.example.thinking.in.spring.dependency.lookup;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 通过{@link ObjectProvider}进行依赖查找
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月20日 16:57:00
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前 ObjectProviderDemo 作为配置类
        applicationContext.register(ObjectProviderDemo.class);
        //启动 Spring应用上下文
        applicationContext.refresh();

        //依赖查找集合对象
        lookupByObjectProvider(applicationContext);
        lookupIfAvailable(applicationContext);
        lookupByString(applicationContext);

        //关闭 Spring应用上下文
        applicationContext.close();
    }

    private static void lookupByString(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
//        Iterable<String> stringIterable = beanProvider;
//        for (String string : stringIterable){
//            System.out.println(string);
//        }
        beanProvider.stream().forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        User user = beanProvider.getIfAvailable(User::new);
        System.out.println("当前 User 对象：" + user);
    }

    @Bean
    @Primary
    public String helloWorld(){// 方法名就是Bean名称
        return "hello,world";
    }
    @Bean
    public String message(){
        return "Message";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());

    }
}
