package com.rich.webapps.dictionary;

import com.rich.standar.ServletException;
import com.rich.standar.http.HttpServlet;
import com.rich.standar.http.HttpServletRequest;
import com.rich.standar.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String english = req.getParameter("english");
        String translate = translate(english);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.printf("<h1>翻译服务<h1>\r\n");
        writer.printf("<p>%s 的意思是 %s\r\n", english, translate);
    }

    private String translate(String english) {
        return "英语";
    }
}
