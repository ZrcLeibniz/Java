package zrc.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\lenovo\\Desktop\\a\\test.mp4");
            fileOutputStream = new FileOutputStream("F:\\StudyFile\\text.mp4");
            byte[] bytes = new byte[1024 * 1024];
            int readCount = 0;
            while ((readCount = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes);
            }
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
