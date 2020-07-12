package zrc.map;

import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("url", "jdbc:mysql://localhost:3306/finally");
        properties.setProperty("driver", "com.mysql.jdbc.Driver");
        properties.setProperty("username", "root");
        properties.setProperty("password", "00000000");
        System.out.println("url" + "---" + properties.getProperty("url"));
        System.out.println("driver" + "---" + properties.getProperty("driver"));
        System.out.println("username" + "---" + properties.getProperty("username"));
        System.out.println("password" + "---" + properties.getProperty("password"));
    }
}

