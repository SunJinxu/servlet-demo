package io.sunjinxu.servlet;

import javax.servlet.*;
import java.io.IOException;

public class MyServlet implements Servlet {
    /**
     * @author: sunjinxu
     * @date: 10/10/2022 4:49 PM
     * @description: 初始化
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("io.sunjinxu.servlet.MyServlet 初始化...");
    }

    /**
     * @author: sunjinxu
     * @date: 10/10/2022 4:50 PM
     * @description: Servlet配置
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * @author: sunjinxu
     * @date: 10/10/2022 4:49 PM
     * @description: 服务
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("io.sunjinxu.servlet.MyServlet 被调用...");
        servletResponse.getWriter().write("Hello World !");
    }

    /**
     * @author: sunjinxu
     * @date: 10/10/2022 4:50 PM
     * @description: Servlet信息
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * @author: sunjinxu
     * @date: 10/10/2022 4:50 PM
     * @description: 销毁
     */
    @Override
    public void destroy() {
        System.out.println("io.sunjinxu.servlet.MyServlet 被销毁...");
    }
}
