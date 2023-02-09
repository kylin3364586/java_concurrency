package com.kk.paystarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-09- 15:17:00
 */
@Configuration
@EnableConfigurationProperties({PayProperties.class})
public class PayAutoConfiguration {


    @Autowired
    private PayProperties payProperties;

    //将配置类 PayProperties 中的属性值赋值给 PayService（待装载的配置类），并注入到IOC容器
    @Bean
    public PayService payService(){
        return new PayService(payProperties);
    }
}
