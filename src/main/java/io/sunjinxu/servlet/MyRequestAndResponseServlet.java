package io.sunjinxu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyRequestAndResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 使用OutPutStream进行输出
//        ServletOutputStream outputStream = resp.getOutputStream();
//        outputStream.print("aaa");    可以正确返回
//        outputStream.print("这里是中国！");   报错，不是ISO 8859-1字符
//        outputStream.write("aaa".getBytes()); 可以正常运行
//        outputStream.write("这里是中国！".getBytes("GBK")); 可以正常运行，但是需要调整编码形式

        /**     采用设置标签头的形式
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        outputStream.write("这里是中国！".getBytes("UTF-8"));
         */

//        outputStream.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
//        outputStream.write("这里是中国！\n".getBytes("UTF-8"));

        // 2 使用PrintWriter输出
        resp.setContentType("text/html;charset=UTF-8"); // 这是最简单的方法
        PrintWriter writer = resp.getWriter();
        writer.write("这里是中国！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
