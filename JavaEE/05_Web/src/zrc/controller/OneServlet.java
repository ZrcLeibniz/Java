package zrc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.通过请求对象，读取【请求行】中的【url】信息
        String requestURL = req.getRequestURL().toString();
        // 2.通过请求对象，读取【请求行】中的【method】对象
        String method = req.getMethod();
        // 3.通过请求对象，读取【请求行】中的uri信息
        String requestURI = req.getRequestURI();

        System.out.println("URL: " + requestURL);
        System.out.println("method: " + method);
        System.out.println("URI: " + requestURI);
    }
}
