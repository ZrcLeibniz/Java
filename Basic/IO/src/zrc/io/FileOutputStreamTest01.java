package zrc.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
java.io.FileOutputStream 文件字节输出流，负责写 从内存到硬盘
    这种方式会将原文件清空后写入！谨慎使用！
 */
public class FileOutputStreamTest01 {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            // 在构造方法中将append参数设置为true，可以以追加的方式在文件末尾写入，不会清空原文件内容
            fileOutputStream = new FileOutputStream("F:\\StudyFile\\b.txt", true);
            String str = "我是法外狂徒-张三";
            byte[] bytes = str.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
