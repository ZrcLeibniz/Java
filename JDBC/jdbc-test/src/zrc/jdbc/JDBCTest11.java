package zrc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCTest11 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String username = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");
        try {
            Class.forName("driver");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "update account set balance = ? where actno = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, 10000);
            preparedStatement.setString(2, "111");
            int count = preparedStatement.executeUpdate();
            preparedStatement.setDouble(1, 10000);
            preparedStatement.setString(2, "222");
            count += preparedStatement.executeUpdate();
            System.out.println(count == 2 ? "转账成功" : "转账失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
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
