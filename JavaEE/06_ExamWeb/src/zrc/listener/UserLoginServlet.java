package zrc.listener;

import zrc.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 调用请求对象对请求体对象使用utf-8字符集进行解码
        req.setCharacterEncoding("utf-8");
        // 2. 调用请求对象读取请求体参数信息
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        // 3. 调用Dao将查询验证信息推送到数据库服务器上
        UserDao userDao = new UserDao();
        int login = userDao.login(userName, password);
        // 4. 调用响应对象，根据验证结果将不同资源文件地址写入到响应头
        if (login == 1) {
            resp.sendRedirect("/myWeb/index.html");
        } else {
            resp.sendRedirect("/myWeb/login_error.html");
        }
    }

}
