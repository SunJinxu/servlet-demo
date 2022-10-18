package io.sunjinxu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            由于表单是通过post的方式提交的，而post方法是通过将表单的数据封装在了request对象中，
            因此采用request.setCharacterEncoding("UTF-8)即可避免中文乱码；

            但是如果使用get方式提交，那么会在消息行中进行传递
            因此，此时需要先使用ISO8859-1进行decode，再重新使用UTF-8进行coding，然后就可以解决乱码问题了

            此外还有一个方法是在Tomcat的server.xml中将编码格式配置为UTF-8，但是这样太麻烦了
         */
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String[] hobbies = req.getParameterValues("hobbies");
        String description = req.getParameter("textarea");
        String hiddenValue = req.getParameter("aaa");


        System.out.println(username + "\n" + hobbies + "\n" + description + "\n" + hiddenValue);
    }
}
