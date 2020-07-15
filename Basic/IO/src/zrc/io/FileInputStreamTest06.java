package zrc.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
FileInputStream类的其它常用方法
    long skip(long n)：可以跳过几个字节不读
*/
public class FileInputStreamTest06 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("F:\\StudyFile\\b.txt");
            byte[] bytes = new byte[4];
            fileInputStream.skip(2);
            int read = 0;
            while ((read = fileInputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes));
            }
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
