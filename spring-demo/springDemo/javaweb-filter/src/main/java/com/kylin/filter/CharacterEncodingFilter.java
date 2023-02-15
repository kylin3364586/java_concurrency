package com.kylin.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 过滤器
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-15- 11:27:00
 */
public class CharacterEncodingFilter implements Filter {

    //容器启动调用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化了......");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);//过滤器链，调用下一个过滤器
    }

    //容器停止调用
    @Override
    public void destroy() {
        System.out.println("过滤器销毁......");
    }
}
