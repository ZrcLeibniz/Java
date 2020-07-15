package zrc.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
int read(byte[] b)
    一次最多读取b.length个字节，减少硬盘和内存的交互，提高程序的执行效率，将读取的内容放入byte数组中
在IDEA中默认的当前路径是Project的根
 */
public class FileInputStreamTest03 {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("F:\\StudyFile\\b.txt");
            byte[] bytes = new byte[4];
            // 此方法的返回值是读到的字节数量（不是字节本身）
            // 在将读到的内容转换为字符串时，不应该全部转换，而是应该读到几个转换几个
            int read = inputStream.read(bytes);
            System.out.println(read);
            System.out.println(new String(bytes,0, read));
            int read1 = inputStream.read(bytes);
            System.out.println(read1);
            System.out.println(new String(bytes,0, read));
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
