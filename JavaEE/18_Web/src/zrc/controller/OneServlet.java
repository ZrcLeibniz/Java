package zrc.controller;

import zrc.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student mike = new Student(100, "Mike");
        Student allen = new Student(200, "Allen");
        Student smith = new Student(300, "Smith");
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(mike);
        arrayList.add(allen);
        arrayList.add(smith);
        request.setAttribute("student", arrayList);
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }
}
