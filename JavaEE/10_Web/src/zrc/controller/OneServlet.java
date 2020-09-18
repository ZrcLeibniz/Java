package zrc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用请求头读取请求头参数信息
        String username = request.getParameter("username");
        String money = request.getParameter("money");
        // 2.开卡
        Cookie cookie1 = new Cookie("username", username);
        Cookie cookie2 = new Cookie("money", money);
        // 3.将Cookie写入到响应头之中
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        // 4.通知Tomcat将点餐页面写入响应体中交给浏览器
        request.getRequestDispatcher("/index2.html").forward(request, response);
    }
}
