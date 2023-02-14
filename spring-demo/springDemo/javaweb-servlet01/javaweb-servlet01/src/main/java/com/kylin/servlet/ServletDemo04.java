package com.kylin.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 转发请求路径
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-14- 14:57:00
 */
public class ServletDemo04 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*04转发到 /gp*/
        ServletContext servletContext = this.getServletContext();
        servletContext.getRequestDispatcher("/gp").forward(req,resp);

    }
}
