package zrc.io;

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            // 当一个流的构造方法中需要一个流的时候，这个传进来的流成为节点流
            // 外部负责包装的流称为包装流或处理流
            fileInputStream = new FileInputStream("F:\\StudyFile\\a.txt");
            inputStreamReader = new InputStreamReader(fileInputStream);
            fileReader = new FileReader("F:\\StudyFile\\a.txt");
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader = new BufferedReader(inputStreamReader);
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
