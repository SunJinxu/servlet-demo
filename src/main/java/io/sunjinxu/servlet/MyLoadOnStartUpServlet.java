package io.sunjinxu.servlet;

import javax.servlet.*;
import java.io.IOException;

public class MyLoadOnStartUpServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("io.sunjinxu.servlet.MyLoadOnStartUpServlet 初始化...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
