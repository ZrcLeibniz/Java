package zrc.controller;

import zrc.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 调用请求对象读取请求头中的参数
        Integer userId = Integer.parseInt(req.getParameter("userId"));
        // 2. 调用Dao将用户编号填充到delete命令并发送到数据库服务器
        UserDao userDao = new UserDao();
        int result = userDao.delete(userId);
        // 3. 调用响应对象将处理结果以二进制写入到响应体中
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (result == 1) {
            writer.print("<font style = 'color:red'; font-size:40>删除成功</font>");
        } else  {
            writer.print("<font style = 'color:red'; font-size:40>删除失败</font>");
        }
    }
}
