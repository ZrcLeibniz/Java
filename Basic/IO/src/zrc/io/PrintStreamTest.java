package zrc.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("F:\\StudyFile\\c.txt"));
            System.setOut(printStream);
            System.out.println("法外狂徒-张三");
            System.out.println("转移标准输出流的输出方向到一个日志文件");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
