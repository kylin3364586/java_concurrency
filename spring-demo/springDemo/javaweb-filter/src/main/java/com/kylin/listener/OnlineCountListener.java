package com.kylin.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-15- 13:58:00
 */
public class OnlineCountListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();

        System.out.println(se.getSession().getId());

        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if(null == onlineCount){
            onlineCount = new Integer(0);
        }else{
            onlineCount = 1 + onlineCount.intValue();
        }
        servletContext.setAttribute("onlineCount",onlineCount);

    }


    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();


        System.out.println(se.getSession().getId());

        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if(null == onlineCount){
            onlineCount = new Integer(0);
        }else{
            onlineCount = onlineCount.intValue() -1;
        }
        servletContext.setAttribute("onlineCount",onlineCount);
    }
}
