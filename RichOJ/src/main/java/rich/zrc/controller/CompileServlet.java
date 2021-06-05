package rich.zrc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rich.zrc.compile.Answer;
import rich.zrc.compile.Question;
import rich.zrc.compile.Task;
import rich.zrc.dao.ProblemDao;
import rich.zrc.pojo.CompileRequest;
import rich.zrc.pojo.CompileResponse;
import rich.zrc.pojo.Problem;
import rich.zrc.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/compile")
public class CompileServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.先从req对象中读取body数据
        String s = HttpUtil.readBody(req);
        // 2.把这个json数据转换为对象
        CompileRequest compileRequest = gson.fromJson(s, CompileRequest.class);
        // 3.找出与题目对应的测试代码
        ProblemDao problemDao = new ProblemDao();
        Problem problem = problemDao.selectOne(compileRequest.getId());
        String testCode = problem.getTestCode();
        // 4.拼接用户提交的代码
        String requestCode = compileRequest.getCode();
        String finalCode = mergeCode(requestCode, testCode);
        // 5.创建Task对象，执行代码
        Task task = new Task();
        Question question = new Question();
        question.setCode(finalCode);
        Answer answer = null;
        try {
            answer = task.compileAndRun(question);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 6.返回结果
        CompileResponse compileResponse = new CompileResponse();
        compileResponse.setErrNo(answer.getErrNo());
        compileResponse.setReason(answer.getReason());
        compileResponse.setStdout(answer.getStdOut());
        String respString = gson.toJson(compileResponse);
        resp.setStatus(200);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(respString);
    }

    private String mergeCode(String requestCode, String testCode) {
        int pos = requestCode.lastIndexOf("}");
        if (pos == -1) {
            return null;
        }
        return requestCode.substring(0, pos) + testCode + "}";
    }
}
