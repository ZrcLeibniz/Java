package zrc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest10 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sjk", "root", "00000000");
            String sql = "update student set sname = ? where sid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "rich");
            preparedStatement.setString(2, "444");
            int count = preparedStatement.executeUpdate();
            preparedStatement.setString(1, "rich&rich");
            preparedStatement.setString(2, "444");
            int count2 = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
