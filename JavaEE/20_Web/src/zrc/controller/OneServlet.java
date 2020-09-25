package zrc.controller;

import zrc.entity.Student;

import javax.servlet.ServletContext;
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
        ServletContext application = request.getServletContext();
        HttpSession session = request.getSession();
        application.setAttribute("sid", 10);
        session.setAttribute("sname", "mike");
        request.setAttribute("home", "西安");
        Student student = new Student(10, "mike");
        request.setAttribute("key", student);
        request.setAttribute("key1", "100");
        request.setAttribute("key2", 200);
        request.getRequestDispatcher("/index_1.jsp").forward(request, response);
    }
}
