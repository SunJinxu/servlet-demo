package io.sunjinxu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MyCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取cookie内容
        getCookieContent(req);

        resp.setContentType("text/html;charset=UTF-8");
        Cookie cookie = new Cookie("username", "SunJinxu");
//        中文cookie必须要用URLEndoder进行编码
        Cookie chineseCookie = new Cookie("country", URLEncoder.encode("中国", "UTF-8"));
        cookie.setMaxAge(1000);
        chineseCookie.setMaxAge(1000);
//        Cookie甚至是不可以跨域名的，二级域名也不允许。如果想在二级域名中也访问这个域名，可以使用cookie.setDomain()方法把域名加入进去
//        Cookie可以通过cookie.setPath()来指定它在访问什么路径的Servlet时候携带
        resp.addCookie(cookie);
        resp.addCookie(chineseCookie);
        resp.getWriter().write("向浏览器发送了2个Cookie");
    }

    /**
     * @author: sunjinxu
     * @date: 13/10/2022 10:29 AM
     * @description: 此方法可以获取用户上次的访问时间
     */
    void getCookieContent (HttpServletRequest req) throws UnsupportedEncodingException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null || cookies.length == 0)
            return;
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
            System.out.println(name + ":" + value);
        }
    }
}
