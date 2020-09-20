package zrc.listener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String result = "Java<br/>MySQL<br/>Html<br/>";
        String result2 = "红烧排骨<br/>梅菜肘子<br/>糖醋里脊";
        PrintWriter writer = resp.getWriter();
        writer.print(result);
        writer.print(result2);
    }
}
