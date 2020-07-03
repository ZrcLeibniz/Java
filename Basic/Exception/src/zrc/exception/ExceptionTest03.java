package zrc.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest03 {
    public static void main(String[] args) {
        System.out.println("main begin");
        try {
            m1();
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在，路径可能有点问题");
            e.printStackTrace();
        }
        System.out.println("main over");
    }

    private static void m1() throws FileNotFoundException {
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 over");
    }

    private static void m2() throws FileNotFoundException {
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 over");
    }

    private static void m3() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\StudyFile\\a.txt");
    }
}
