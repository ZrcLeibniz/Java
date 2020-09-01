package zrc.jdbc;


import java.sql.*;

public class JDBCTest01 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 1.注册驱动
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            // 2.获取连接
            String url = "jdbc:mysql://localhost:3306/sjk";
            // 其中jdbc:mysql://表示通信协议
            // 其中localhost:3306表示服务器IP地址:软件端口
            // finally表示服务器上某个资源名
            String username = "root";
            String password = "00000000";
            connection = DriverManager.getConnection(url, username, password);
            // 3.获取数据库操作对象
            statement = connection.createStatement();
            // 4.执行SQL语句
            String sql = "insert into t_user(uid,uname,pwd) values ('888','rich','888')";
            int i = statement.executeUpdate(sql);
            // 返回值是影响数据库中的记录条数
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement == null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection == null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 5.处理查询结果集
        // 6.释放资源
    }
}
