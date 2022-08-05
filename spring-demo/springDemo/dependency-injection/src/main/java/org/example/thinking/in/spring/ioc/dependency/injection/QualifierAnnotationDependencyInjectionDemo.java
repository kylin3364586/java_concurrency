package org.example.thinking.in.spring.ioc.dependency.injection;

import org.example.thinking.in.spring.ioc.dependency.injection.annotation.UserGroup;
import org.example.thinking.in.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * {@link Qualifier }注解  依赖注入
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月04日 09:34:00
 */
public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired
    private User user; //superUser

    @Autowired
    @Qualifier("user") //1.限定名称
    private User myUser;//user

    @Autowired
    private Collection<User> allUsers; //2个 Bean  user+superUser

    @Autowired
    @Qualifier //2.逻辑分组
    private Collection<User> qualifierUsers; //2个 Bean user1+user2

    @Autowired
    @UserGroup
    private Collection<User> userGroupUsers; // 2个 Bean  user3+user4

    @Bean
    @Qualifier  //进行逻辑分组
    public User user1(){
        return createUser(7L);
    }

    @Bean
    @Qualifier  //进行逻辑分组
    public User user2(){
        return createUser(8L);
    }

    @Bean
    @UserGroup
    public User user3(){
        return createUser(9L);
    }

    @Bean
    @UserGroup
    public User user4(){
        return createUser(10L);
    }

    private static User createUser(Long id){
        User user = new User();
        user.setId(id);
        return user;
    }

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class 配置类
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        //读取 XML
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:\\META-INF\\dependency-lookup-context.xml";
        //加载 XML 资源
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        //启动 Spring应用上下文
        applicationContext.refresh();

        //依赖查找 AnnotationDependencyFieldInjectionDemo Bean
        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);

        System.out.println("user:" + demo.user);
        System.out.println("myUser:" + demo.myUser);
        System.out.println("allUsers:" + demo.allUsers);
        System.out.println("qualifierUsers:" + demo.qualifierUsers);
        System.out.println("userGroupUsers:" + demo.userGroupUsers);

        //关闭 Spring应用上下文
        applicationContext.close();



    }
}
