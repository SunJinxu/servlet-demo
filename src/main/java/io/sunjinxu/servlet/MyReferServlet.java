package io.sunjinxu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyReferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ReferServlet执行...");
        String referer = req.getHeader("Referer");
        if (referer == null || !referer.contains("localhost:9090/index.jsp")) {
            System.out.println("链接来源不合法！");
            System.out.println(referer);
            resp.sendRedirect("/index.jsp");
            return;
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("New Movie");
    }
}
