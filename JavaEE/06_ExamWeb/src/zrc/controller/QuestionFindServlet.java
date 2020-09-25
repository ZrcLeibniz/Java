package zrc.controller;

import zrc.dao.QuestionDao;
import zrc.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer questionId = Integer.parseInt(request.getParameter("questionId"));
        QuestionDao questionDao = new QuestionDao();
        Question question = questionDao.find(questionId, request);
        request.setAttribute("question", question);
        request.getRequestDispatcher("/find.jsp").forward(request, response);
    }
}
