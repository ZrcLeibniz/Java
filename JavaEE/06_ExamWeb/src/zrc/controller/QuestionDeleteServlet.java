package zrc.controller;

import zrc.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer questionId = Integer.parseInt(request.getParameter("questionId"));
        QuestionDao questionDao = new QuestionDao();
        int delete = questionDao.delete(questionId, request);
        if (delete == 1) {
            request.setAttribute("info", "试题删除成功");
        } else {
            request.setAttribute("info", "试题删除失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
