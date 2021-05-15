package rich.zrc.compile;

import rich.zrc.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

// 用这个类表示完整的编译运行过程
public class Task {
    /*
        此处罗列出用于进程间通讯的临时文件名
     */

    // 所有的临时文件都放入这个目录中
    private String WORK_DIR;
    // 要编译执行的类名，也就影响到源代码的文件名
    private String CLASS = "Solution";
    // 要编译执行的文件名
    private String CODE;
    // 程序标准输出的文件
    private String STDOUT;
    // 程序标准错误的文件
    private String STDERR;
    // 程序编译出错的信息
    private String COMPILE_ERROR;

    public Task() {
        WORK_DIR = "./tmp/" + UUID.randomUUID().toString() + "/";
        CODE = WORK_DIR + CLASS + ".java";
        STDOUT = WORK_DIR + "stdout.txt";
        STDERR = WORK_DIR + "stderr.txt";
        COMPILE_ERROR = WORK_DIR + "compile_error.txt";
    }

    public Answer compileAndRun(Question question) throws IOException, InterruptedException {
        Answer answer = new Answer();
        /*
            0.给这些临时文件准备好一个目录
                判断WORK_DIR是否存在，如果存在就跳过，如果不存在则创建
         */
        File file = new File(WORK_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        /*
            1.先要准备好需要用到的临时文件
                要编译的源代码文件
                编译出错要放进一个文件
                最终运行的标准输出和标准错误也要放到文件中
         */
        FileUtil.writeFIle(CODE, question.getCode());
        /*
            2.构造编译指令，并进行执行，预期得到的结果:
                如果编译成功，就是一个对应的.class
                如果编译出错，就将出错的结果写入到之前准备好的标准错误文件中
         */
        String compileCmd = String.format("javac -encoding utf-8 %s -d %s", CODE, WORK_DIR);
        System.out.println(compileCmd);
        CommandUtil.run(compileCmd, null, COMPILE_ERROR);
        String compileError = FileUtil.readFile(COMPILE_ERROR);
        if (!compileError.equals("")) {
            answer.setErrNo(1);
            answer.setReason(compileError);
            return answer;
        }
        /*
            3.构造运行指令，并进行执行，预期得到的结果:
                如果执行成功，将这个代码的执行结果输入到标准输出文件中
                如果执行失败，将这个代码的错误堆栈信息输入到标准错误文件中
         */
        String runCmd = String.format("java -classpath %s %s", WORK_DIR, CLASS);
        System.out.println(runCmd);
        CommandUtil.run(runCmd, STDOUT, STDERR);
        String runError = FileUtil.readFile(STDERR);
        if (!runError.equals("")) {
            answer.setErrNo(2);
            answer.setReason(runError);
            return answer;
        }
        /*
            4.把最终结果构造成一个Answer对象并返回
         */
        answer.setErrNo(0);
        String runStdout = FileUtil.readFile(STDOUT);
        answer.setStdOut(runStdout);
        return answer;
    }

    public static void main(String[] args) {
        Task task = new Task();
        Question question = new Question();
        question.setCode("public class Solution {\n" +
                "    public static void main(String[] args) {\n" +
                "        String s = null;\n" +
                "        s.length();\n" +
                "    }\n" +
                "}");
        try {
            Answer answer = task.compileAndRun(question);
            System.out.println(answer);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
