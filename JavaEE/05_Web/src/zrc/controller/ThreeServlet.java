package zrc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    1.浏览器以GET方式发送请求，请求参数保存在请求头中，在Http请求协议包到大Http服务器后，第一件事就是
    解码请求头二进制内容，由tomcat负责解码，Tomcat9.0默认使用【UTF-8】字符集欸，可以解释一切国家文字
    2.浏览器以POST方式发送请求，请求参数保存在请求体中，在Http请求协议包到大Http服务器后，第一件事就是
    进行解码二进制内容，由当前请求对象负责解码，request默认使用【iso-8859-1】字符集
 */

public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("从请求头中得到的参数值：" + username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        System.out.println("从请求体中得到的参数值：" + username);
    }
}
