package zrc.listener;

import zrc.dao.UserDao;
import zrc.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 调用Dao将查询命令推送到数据库服务器上，得到所有用户信息【List】
        UserDao userDao = new UserDao();
        List<Users> select = userDao.select();
        // 2. 调用响应对象，将用户信息结合<table>标签命令以二进制形式写入响应体
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<table border='2' align='center'>");
        writer.print("<tr>");
        writer.print("<td>用户姓名</td>");
        writer.print("<td>用户密码</td>");
        writer.print("<td>用户性别</td>");
        writer.print("<td>用户邮箱</td>");
        writer.print("<td>删除操作</td>");
        writer.print("<td>更新操作</td>");
        writer.print("</tr>");
        for (Users user : select) {
            writer.print("<tr>");
            writer.print("<td>" + user.getUsername() + "</td>");
            writer.print("<td>" + user.getPassword() + "</td>");
            writer.print("<td>" + user.getSex() + "</td>");
            writer.print("<td>" + user.getEmail() + "</td>");
            writer.print("<td><a href='/myWeb/user/delete?userId=" + user.getUserId() + "'>删除用户</a></td>");
            writer.print("<td><a href='/myWeb/user/update?userId=" + user.getUserId() + "'>修改用户</a></td>");
            writer.print("</tr>");
        }
        writer.print("</table>");
    }
}
