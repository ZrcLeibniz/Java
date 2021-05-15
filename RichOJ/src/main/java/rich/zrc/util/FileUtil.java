package rich.zrc.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 使用这个类封装一下IO操作
public class FileUtil {
    public static String readFile(String filePath) {
        StringBuilder result = new StringBuilder();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            while (true) {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                result.append((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }

    public static void writeFIle(String filePath, String content) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
            outputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}