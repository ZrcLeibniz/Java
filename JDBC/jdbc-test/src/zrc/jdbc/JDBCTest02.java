package zrc.jdbc;

import java.sql.*;

public class JDBCTest02 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            String url = "jdbc:mysql://localhost:3306/sjk";
            String username = "root";
            String password = "00000000";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "delete from t_user where uid = '888'";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
