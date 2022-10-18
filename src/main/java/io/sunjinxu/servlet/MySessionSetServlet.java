package io.sunjinxu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MySessionSetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // session可以设置最长过期时间：1 web.xml 2 setMaxInactiveInterval()方法
        // 这里的session时间指的是未活动时间
        // 通过session的setAttribute()和getAttribute()方法可以加入购买记录

        // 由于Session是通过向浏览器传递一个key为JESSIONID的cookie判断用户是否为登陆用户，所以禁用cookie会造成影响
        // 解决方法：通过重写URL进行传递

        // 可以实现用户免登陆
        HttpSession session = req.getSession();
        session.setAttribute("name", "SunJinxu");
//        String url = "/MySessionGetServlet";
//        resp.sendRedirect(resp.encodeURL(url));
    }
}
