package zrc.controller;

import zrc.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.从当前用户的session对象中得到系统提供的四道题目信息
        HttpSession session = request.getSession();
        ArrayList<Question> questions = (ArrayList<Question>) session.getAttribute("key");
        int score = 0;
        // 2.从请求包中读取用户对于四道题目给出的答案
        // 3.判分
        for (Question question : questions) {
            String answer = question.getAnswer();
            Integer questionId = question.getQuestionId();
            String userAnswer = request.getParameter("answer_" + questionId);
            if (userAnswer.equals(answer)) {
                score += 25;
            }
        }
        // 4.将分数写入request作为共享数据
        request.setAttribute("info", "本次考试成绩:" + score);
        // 5.请求转发调用JSP将用户本次考试分数写入到响应体中
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
