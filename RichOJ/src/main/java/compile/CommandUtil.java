package compile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CommandUtil {
    // run方法用于创建进程，执行命令
    // stdOutFile指定标准输出写到哪个文件中
    // stdErrFile指定标准错误写到哪个文件中
    public static int run(String cmd, String stdOutFile, String stdErrFile) throws IOException, InterruptedException {
        // Java中对于多进程的操作其实是比较粗糙的，不方便进行精细化的操作
        // 我们可以使用Runtime类完成进程的创建
        // Runtime类比较特殊，在使用时不需要创建新的实例，而是使用现有的实例即可
        // 一个Java程序中RunTime的实例只有唯一一个
        Process process = Runtime.getRuntime().exec(cmd);
        if (stdOutFile != null) {
            InputStream stdOutFrom = null;
            FileOutputStream stdOutTo = null;
            try {
                stdOutFrom = process.getInputStream();
                stdOutTo = new FileOutputStream(stdOutFile);
                while (stdOutFrom.read() != -1) {
                    byte[] cur = new byte[16];
                    stdOutTo.write(cur);
                }
            } finally {
                if (stdOutFrom != null) {
                    stdOutFrom.close();
                }
                if (stdOutTo != null) {
                    stdOutTo.close();
                }
            }
        }
        if (stdErrFile != null) {
            InputStream stdErrFrom = null;
            FileOutputStream stdErrorTo = null;
            try {
                stdErrFrom = process.getErrorStream();
                stdErrorTo = new FileOutputStream(stdErrFile);
                byte[] cur = new byte[16];
                while (stdErrFrom.read(cur) != -1) {
                    stdErrorTo.write(cur);
                }
            } finally {
                if (stdErrFrom != null) {
                    stdErrFrom.close();
                }
                if (stdErrorTo != null) {
                    stdErrorTo.close();
                }
            }
        }
        return process.waitFor();
    }

    public static void main(String[] args) {
        try {
            int javac = CommandUtil.run("javac", "./stdOut.txt", "./stdErr.txt");
            System.out.println(javac);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

