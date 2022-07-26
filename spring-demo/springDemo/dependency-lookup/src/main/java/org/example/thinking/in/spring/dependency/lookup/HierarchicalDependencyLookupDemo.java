package org.example.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 层次性依赖查找
 *
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月25日 09:46:00
 */
public class HierarchicalDependencyLookupDemo {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前 ObjectProviderDemo 作为配置类
        applicationContext.register(HierarchicalDependencyLookupDemo.class);
        //启动 Spring应用上下文
        applicationContext.refresh();

        // 1.获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
//        System.out.println("当前BeanFactory的 BeanFactory:" + beanFactory.getParentBeanFactory());

        // 2.设置Parent BeanFactory
        HierarchicalBeanFactory parentBeanFactory = createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
//        System.out.println("当前BeanFactory的 Parent BeanFactory:" + beanFactory.getParentBeanFactory());

        displayLocalBean(beanFactory,"user");
        displayLocalBean(parentBeanFactory,"user");

        displayContainsBean(beanFactory,"user");
        displayContainsBean(parentBeanFactory, "user");

        //关闭 Spring应用上下文
        applicationContext.close();
    }


    private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 Bean Factory[%s] 是否包含 Contains Bean[name : %s] : %s\n",
                beanFactory,
                beanName,
                containsBean(beanFactory, beanName));
    }

    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName){
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if(parentBeanFactory instanceof HierarchicalBeanFactory){
            HierarchicalBeanFactory parentHierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if(containsBean(parentHierarchicalBeanFactory, beanName)){
                return true;
            }
        }
        return beanFactory.containsLocalBean(beanName);
    }

    private static void displayLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 Bean Factory[%s] 是否包含 Local Bean[name : %s] : %s\n",
                beanFactory,
                beanName,
                beanFactory.containsLocalBean(beanName));
    }

    private static HierarchicalBeanFactory createParentBeanFactory() {
        //创建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //加载配置
        reader.loadBeanDefinitions("classpath:\\META-INF\\dependency-lookup-context.xml");
        return beanFactory;
    }
}
