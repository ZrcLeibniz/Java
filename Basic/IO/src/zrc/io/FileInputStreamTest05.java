package zrc.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
FileInputStream类的其它常用方法
    int available()：返回流中剩余的没有读到的字节数量
 */
public class FileInputStreamTest05 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            // available()方法的演示，但是这种方式不适用于太大的文件
            fileInputStream = new FileInputStream("F:\\StudyFile\\a.txt");
            int available = fileInputStream.available();
            byte[] bytes = new byte[available];
            fileInputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
