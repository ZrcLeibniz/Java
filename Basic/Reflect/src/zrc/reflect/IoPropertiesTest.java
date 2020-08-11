package zrc.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class IoPropertiesTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        String path = Thread.currentThread().getContextClassLoader().getResource("classinfo.properties").getPath();
//        FileReader fileReader = new FileReader(path);
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("classinfo.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        String aClass = properties.getProperty("className");
        Class.forName(aClass);
    }
}
