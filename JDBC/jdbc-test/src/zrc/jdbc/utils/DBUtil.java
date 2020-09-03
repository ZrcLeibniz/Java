package zrc.jdbc.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    /*
     * 工具类中的构造方法一般都是私有的
     * 因为工具类中的方法都是静态的不需要new对象，直接采用类名调用
     */
    private DBUtil() {
    }

    public static Connection getConnection(String pUrl) throws ClassNotFoundException, SQLException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(pUrl);
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String username = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       close(connection, statement);
    }

    public static void close(Connection connection, Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
