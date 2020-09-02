package zrc.jdbc;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JDBCTest06 {
    public static void main(String[] args) {
        Map<String, String> map = initUI();
        boolean login = login(map);
        if (login == true) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

    private static boolean login(Map<String, String> loginMap) {
        boolean loginSuccess = false;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String username = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "select * from t_user where uname = '" + loginMap.get("username") + "' and pwd = '" + loginMap.get("password") + "'";
            ResultSet query = statement.executeQuery(sql);
            if (query.next()) {
                loginSuccess = true;
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
        return loginSuccess;
    }

    private static Map<String, String> initUI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户名:");
        String username = scanner.nextLine();
        System.out.println("密码:");
        String password = scanner.nextLine();
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return map;
    }
}
