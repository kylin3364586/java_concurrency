package org.example.thinking.in.spring.ioc.bean.scope;

import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * 自定义 Scope {@link ThreadLocalScope} 示例
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月09日 18:31:00
 */
public class ThreadLocalScopeDemo{

    @Bean
    @Scope(ThreadLocalScope.THREAD_LOCAL)
    public User user(){
        return createUser();
    }

    private static User createUser(){
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }


    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类
        applicationContext.register(ThreadLocalScopeDemo.class);

        applicationContext.addBeanFactoryPostProcessor( beanFactory -> {
             //注册自定义 scope
            beanFactory.registerScope(ThreadLocalScope.THREAD_LOCAL, new ThreadLocalScope());
        });

        // 刷新启动上下文
        applicationContext.refresh();

        scopedBeansByLookup(applicationContext);

         //关闭上下文
        applicationContext.close();
    }

    //依赖查找
    private static void scopedBeansByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(()->{
                User user = applicationContext.getBean("user", User.class);
                System.out.println("user= "+ user);
            });
            thread.start();
        }
    }
}
