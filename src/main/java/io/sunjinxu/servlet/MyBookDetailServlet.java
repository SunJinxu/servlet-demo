package io.sunjinxu.servlet;

import io.sunjinxu.entity.Book;
import io.sunjinxu.entity.DB;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

public class MyBookDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 返回详情
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        Book book = DB.getAll().get(id);
        writer.write("Book Details:");
        writer.write(book.toString());

        // 将浏览历史加入Cookie
        String history = null;
        String newHistory = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("history")) {   // 如果有浏览历史
                history = cookie.getValue();
                String[] bookIds = history.split("_");
                StringBuilder historyStringBuilder  = new StringBuilder(id + '_');
                for (int i = 0; i < bookIds.length - 1; ++i) {
                    historyStringBuilder.append(bookIds[i]);
                    historyStringBuilder.append('_');
                }
                if (bookIds.length < 3)
                    newHistory = historyStringBuilder.append(bookIds[bookIds.length - 1]).toString();
                else
                    newHistory = historyStringBuilder.substring(0, historyStringBuilder.length());
            }
        }
        Cookie cookie = new Cookie("history", newHistory);
        cookie.setMaxAge(30000);
        resp.addCookie(cookie);
    }
}
