package zrc.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
java.io.FileInputStream
    1.文件字节输入流，万能的，任何类型都可以采用这个文件来读
    2.字节的方式，完成输入的方式、完成度的操作（从硬盘-->内存）
 */
public class FileInputStreamTest01 {
    public static void main(String[] args) {
        // 创建文件字节输入流对象
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("F:\\StudyFile\\b.txt");
            int read = inputStream.read();
            int read1 = inputStream.read();
            int read2 = inputStream.read();
            int read3 = inputStream.read();
            int read4 = inputStream.read();
            int read5 = inputStream.read();
            System.out.println(read);
            System.out.println(read1);
            System.out.println(read2);
            System.out.println(read3);
            System.out.println(read4);
            System.out.println(read5);
            int read6 = inputStream.read();
            System.out.println(read6);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
