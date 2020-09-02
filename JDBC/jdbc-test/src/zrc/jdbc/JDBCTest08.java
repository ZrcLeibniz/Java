package zrc.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入desc或asc");
        String keyWords = scanner.nextLine();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sjk";
            String username = "root";
            String password = "00000000";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "select * from student order by age " + keyWords;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3) + resultSet.getString(4));
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
