package com.example.springboot04.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot 中玩转 servlet
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-09- 18:10:00
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    //后台监控,,,, 现在直接使用引用 druid-spring-boot-starter 配置基础参数后，可以直接使用druid后台，无需以下配置
    //因为SpringBoot内置了servlet容器，所以没有web.xmL , 替代方法: ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){

        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123");

        //所有可以访问
        initParameters.put("allow","");

        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    //过滤器
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter( new WebStatFilter());
        Map<String, String> initParameters = new HashMap<>();
        //设置过滤的东西
        initParameters.put("exclusions","*.js,*.css");

        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }
}
