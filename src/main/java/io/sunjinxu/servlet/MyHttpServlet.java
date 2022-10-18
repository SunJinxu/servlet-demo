package io.sunjinxu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class MyHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 浏览器会默认设置缓存，关闭缓存可以进行设置
        resp.setDateHeader("Expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");

        System.out.println("io.sunjinxu.servlet.MyHttpServlet 运行...");
        ServletConfig servletConfig = this.getServletConfig();
        String value = servletConfig.getInitParameter("name");
        System.out.println(value);

        ServletContext servletContext = this.getServletContext();
        String contextValue = "Jesse Sun";
        servletContext.setAttribute("key", contextValue);

        String paramValue = (String)servletContext.getInitParameter("param-name");
        System.out.println(paramValue);

        InputStream resourceAsStream = servletContext.getResourceAsStream("download.png");
        resp.getWriter().write(String.valueOf(resourceAsStream));
    }
}
