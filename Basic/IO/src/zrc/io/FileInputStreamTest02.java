package zrc.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
此程序的缺点在于：一次读取一个字节，硬盘与内存的交互过于频繁，效率很低
 */
public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("F:\\StudyFile\\a.txt");
            int readData = 0;
            while ((readData = inputStream.read()) != -1) {
                System.out.print(readData+" ");
            }
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
