package io.sunjinxu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyForwardSendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "SunJinxu");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/MyForwardRevServlet");
        requestDispatcher.forward(req, resp);
    }
}
