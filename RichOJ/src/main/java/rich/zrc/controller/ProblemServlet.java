package rich.zrc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rich.zrc.dao.ProblemDao;
import rich.zrc.pojo.Problem;
import rich.zrc.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/problem")
public class ProblemServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setContentType("application/json;charset=utf-8");
        String id = req.getParameter("id");
        if (id == null || id.equals("")) {
            selectAll(resp);
        } else {
            selectOne(Integer.parseInt(id), resp);
        }
    }

    private void selectAll(HttpServletResponse resp) throws IOException {
        ProblemDao problemDao = new ProblemDao();
        List<Problem> problems = problemDao.selectAll();
        String s = gson.toJson(problems);
        resp.getWriter().write(s);
    }

    private void selectOne(int problemId, HttpServletResponse resp) throws IOException {
        ProblemDao problemDao = new ProblemDao();
        Problem problem = problemDao.selectOne(problemId);
        String s = gson.toJson(problem);
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = HttpUtil.readBody(req);
        Problem problem = gson.fromJson(body, Problem.class);
        ProblemDao problemDao = new ProblemDao();
        int insert = problemDao.insert(problem);
        resp.setStatus(200);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write("{\"ok\":1}");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setContentType("application/json;charset=utf-8");
        String id = req.getParameter("id");
        if (id == null || id.equals("")) {
            resp.getWriter().write("{\"ok\":0, reason:\"id不存在\"}");
            return;
        }
        ProblemDao problemDao = new ProblemDao();
        int delete = problemDao.delete(Integer.parseInt(id));
        resp.getWriter().write("{\"ok\":1}");
    }
}
