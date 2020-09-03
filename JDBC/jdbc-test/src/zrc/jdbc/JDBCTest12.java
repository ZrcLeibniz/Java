package zrc.jdbc;

import zrc.jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest12 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection("jdbc");
            String sql = "select ename, sal from emp where ename like ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "_A%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String string = resultSet.getString(1);
                double aDouble = resultSet.getDouble(2);
                System.out.println(string + " " + aDouble);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
    }
}
