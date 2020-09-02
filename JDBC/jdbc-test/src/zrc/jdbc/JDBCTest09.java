package zrc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest09 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sjk", "root", "00000000");
            String sql = "insert into student(sid, sname, age, sex) values (?, ?, ?, ?)";
            String sql2 = "update student set sid = ?, sname = ?, age = ?, aex = ? where sid = ?";
            String sql3 = "delete from student where sid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 444);
            preparedStatement.setString(2, "jack");
            preparedStatement.setInt(3, 33);
            preparedStatement.setString(4, "man");
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
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
