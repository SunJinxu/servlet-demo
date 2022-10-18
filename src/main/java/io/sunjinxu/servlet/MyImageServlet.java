package io.sunjinxu.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MyImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage bufferedImage = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font(null, Font.BOLD, 20));
//        graphics.fillRect(0, 0, 80, 20);
        graphics.drawString("1234", 0, 20);

        resp.setHeader("ContentType", "jpeg");
        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
    }
}
