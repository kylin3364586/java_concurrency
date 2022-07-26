package org.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月04日 17:46:00
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
        .forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor);

        });
        ;
    }
}
