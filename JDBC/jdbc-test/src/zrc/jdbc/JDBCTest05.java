package zrc.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest05 {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String username = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "select * from t_user";
            resultSet = statement.executeQuery(sql);
            // 5.处理查询结果集
            while (resultSet.next()) {
                String uid = resultSet.getString("uid");
                String un = resultSet.getString("uname");
                String up = resultSet.getNString("pwd");
                System.out.println(uid + ":" + un + ":" + up);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
}
