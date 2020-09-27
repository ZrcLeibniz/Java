package zrc.controller;

import zrc.dao.QuestionDao;
import zrc.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        // 1.调用Dao对象从question表中随机拿出4道题目
        QuestionDao questionDao = new QuestionDao();
        // 2.将4道题目添加到request中作为共享数据
        List<Question> rand = questionDao.findRand(request);
        session.setAttribute("key", rand);
        // 3.请求转发，申请调用exam.jsp将4道题目写入到响应体
        request.getRequestDispatcher("/exam.jsp").forward(request, response);
    }
}
