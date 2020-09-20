package zrc.listener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用请求对象，读取请求头参数，得到用户选择商品名
        String goodsName = request.getParameter("goodsNames");
        // 2.调用请求对象，向Tomcat索要当前用户在服务端的session对象
        HttpSession session = request.getSession();
        // 3.将用户选购的商品添加到当前用户的session对象中
        Integer goodNums = (Integer) session.getAttribute(goodsName);
        if (goodNums == null) {
            session.setAttribute(goodsName, 1);
        } else {
            session.setAttribute(goodsName, goodNums + 1);
        }
    }
}
