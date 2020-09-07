package zrc.jdbc;

import java.sql.*;

public class JDBC04 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "00000000");
            String sql = "insert into student(sid, sname, sage, ssex) values (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i < 100; i++) {
                preparedStatement.setString(1, Integer.toString(i));
                preparedStatement.setString(2, "zhangsan" + i);
                preparedStatement.setInt(3, 23);
                preparedStatement.setString(4, "men");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
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
