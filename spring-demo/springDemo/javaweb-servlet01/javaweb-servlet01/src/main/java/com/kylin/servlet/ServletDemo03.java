package com.kylin.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 读取配置文件属性
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-14- 14:57:00
 */
public class ServletDemo03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        /*读取web.xml配置文件属性*/
        ServletContext servletContext = this.getServletContext();
        String url = servletContext.getInitParameter("url");
        resp.getWriter().print(url);

    }
}
