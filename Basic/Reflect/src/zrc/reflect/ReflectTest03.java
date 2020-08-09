package zrc.reflect;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
验证反射机制的灵活性
 */
public class ReflectTest03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        FileReader fileReader = new FileReader("E:\\GitWarehouse\\Java\\Basic\\Reflect\\src\\classinfo.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
        fileReader.close();
        String className = properties.getProperty("className");
        System.out.println(className);
        Class aClass = Class.forName(className);
        Object o = aClass.newInstance();
        System.out.println(o);
    }
}
