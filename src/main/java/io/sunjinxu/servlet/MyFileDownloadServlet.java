package io.sunjinxu.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class MyFileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 英文名下载
        String downloadPath = this.getServletContext().getInitParameter("downloadPath") + "download.png";
        String path = this.getServletContext().getRealPath(downloadPath);
        System.out.println(path);
        FileInputStream fileInputStream = new FileInputStream(path);
        String fileName = downloadPath.substring(downloadPath.lastIndexOf("\\") + 1);

        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        // resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));   如果文件名为中文
        int len = 0;
        byte[] bytes = new byte[1024];
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((len = fileInputStream.read(bytes)) > 0)
            outputStream.write(bytes, 0, len);
        outputStream.close();
        fileInputStream.close();
    }
}
