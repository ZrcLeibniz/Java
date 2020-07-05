package zrc.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest05 {
    public static void main(String[] args) {
        try {
            m1();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }

    private static void m1() throws FileNotFoundException {
        m2();
    }

    private static void m2() throws FileNotFoundException {
        m3();
    }

    private static void m3() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\StudyFile\\a.txt");
    }
}
