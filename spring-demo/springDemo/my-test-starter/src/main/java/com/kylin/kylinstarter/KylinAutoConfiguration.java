package com.kylin.kylinstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-09- 11:20:00
 */

@Configuration
//开启自动配置
@EnableConfigurationProperties({KylinProperties.class})
public class KylinAutoConfiguration {

    @Autowired
    private KylinProperties kylinProperties;

    @Bean
    @ConditionalOnMissingBean(KylinService.class)
    public KylinService kylinService(){
        return new KylinService(kylinProperties);
    }
}
