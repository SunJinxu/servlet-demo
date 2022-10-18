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
import java.util.LinkedHashMap;

public class MyBookShelfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

//        展示所有的书籍
        PrintWriter writer = resp.getWriter();
        writer.write("All Books: <br/>");
        LinkedHashMap<String, Book> all = DB.getAll();
        for (Book book : all.values()) {
            writer.write("<a href = '/MyBookDetailServlet?id=" + book.getId() + "'>" + book.getName() + "</a><br/>");
        }

//        展示浏览历史
        String history = null;
        writer.write("Watch history: " + "<br/>");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("history")) {
                history = cookie.getValue();
                String[] bookIds = history.split("_");
                for (String id : bookIds)
                    writer.write(all.get(id).toString() + "<br/>");
            } else {
                Cookie historyCookie = new Cookie("history", "");
                resp.addCookie(historyCookie);
            }
        }
    }
}
