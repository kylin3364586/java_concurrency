package com.kylin.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取资源文件
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-14- 14:57:00
 */
public class ServletDemo05 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*读取.properties 资源文件属性*/
        ServletContext servletContext = this.getServletContext();
//        String resourcePath = "/WEB-INF/classes/db.properties";
        String resourcePath = "/WEB-INF/classes/com/kylin/servlet/aa.properties";
        InputStream inputStream = servletContext.getResourceAsStream(resourcePath);

        Properties properties = new Properties();
        properties.load(inputStream);
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        resp.getWriter().print(username+":"+password);

    }
}
