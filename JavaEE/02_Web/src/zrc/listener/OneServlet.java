package zrc.listener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
抽象类的作用就是降低接口实现类对接口实现过程的难度，将接口中不需要使用的抽象方法教给抽象类完成
降低接口实现类的实现难度

servlet接口：
    init getServletConfig getServletInfo destory service
 */

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送Get请求方式处理 ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送Post请求方式处理");
    }
}
