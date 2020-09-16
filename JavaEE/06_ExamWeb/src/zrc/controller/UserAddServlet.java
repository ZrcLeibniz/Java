package zrc.controller;

import zrc.dao.UserDao;
import zrc.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.调用请求头对象读取请求头信息
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("password");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        Users user = new Users(null, userName, passWord, sex, email);
        // 2.调用UserDao将用户信息填充到Insert命令中
        UserDao userDao = new UserDao();
        int result = userDao.add(user);
        // 3.调用相应对象将处理结果以二进制形式写入到响应对象
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (result == 1) {
            writer.print("<font style = 'color:red'; font-size:40>注册成功</font>");
        } else  {
            writer.print("<font style = 'color:red'; font-size:40>注册失败</font>");
        }
        // Tomcat负责销毁请求对象和响应对象并且将响应协议包推送到发起请求的浏览器上
    }
}
