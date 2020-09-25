package zrc.controller;

import zrc.dao.QuestionDao;
import zrc.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用请求对象，读取请求头中的参数，得到新增试题的内容
        String title = request.getParameter("title");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String answer = request.getParameter("answer");
        Question question = new Question(null, title, optionA, optionB, optionC, optionD, answer);
        // 2.调用Dao对象，将Insert命令推送到数据库中，并得到处理结果
        QuestionDao questionDao = new QuestionDao();
        int add = questionDao.add(question, request);
        // 3.通过请求转发，向Tomcat索要info.jsp将处理结果写入到响应体中
        if (add == 1) {
            request.setAttribute("info", "试题添加成功");
        } else {
            request.setAttribute("info", "试题添加失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
