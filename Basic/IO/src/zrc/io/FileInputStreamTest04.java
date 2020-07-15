package zrc.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
最终版，需要掌握
 */
public class FileInputStreamTest04 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("F:\\StudyFile\\a.txt");
            byte[] bytes = new byte[4];
//            while (true) {
//                int readCount = fileInputStream.read(bytes);
//                if (readCount == -1) {
//                    break;
//                }
//                System.out.print(new String(bytes, 0, readCount));
//            }
            int readCount = 0;
            while ((readCount = fileInputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readCount));
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
