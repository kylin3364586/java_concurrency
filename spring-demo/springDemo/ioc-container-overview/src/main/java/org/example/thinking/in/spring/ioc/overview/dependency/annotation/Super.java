package org.example.thinking.in.spring.ioc.overview.dependency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年07月06日 17:48:00
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
