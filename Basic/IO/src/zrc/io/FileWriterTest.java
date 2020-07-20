package zrc.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("F:\\StudyFile\\a.txt");
            fileWriter = new FileWriter("F:\\StudyFile\\aCopy.txt");
            char[] chars = new char[4];
            int readCount = 0;
            while ((readCount = fileReader.read(chars)) != -1) {
                fileWriter.write(chars);
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
