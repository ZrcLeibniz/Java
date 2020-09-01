package zrc.jdbc;

import java.sql.*;

public class JDBCTest03 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sjk";
            String username = "root";
            String password = "00000000";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
