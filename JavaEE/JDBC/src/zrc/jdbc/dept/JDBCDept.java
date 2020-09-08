package zrc.jdbc.dept;

import java.sql.*;
import java.util.Scanner;

public class JDBCDept {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        String sql_1 = "insert into dept(deptno, danme, loc) values (?, ?, ?)";
        String sql_2 = "select * from dept";
        String sql_3 = "delete from dept where deptno = ?";
        String sql_4 = "update dept set danme = ?, loc = ? where deptno = ?";
        String deptno = "";
        String dname = "";
        String loc = "";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam of study", "root", "00000000");
        PreparedStatement preparedStatement = null;
        System.out.println("***欢迎使用XX公司部门管理系统***");
        System.out.println("***1.添加部门***");
        System.out.println("***2.查询部门***");
        System.out.println("***3.删除部门***");
        System.out.println("***4.更新部门***");
        System.out.println("请输入操作");
        flag = scanner.nextInt();
        if (flag == 1) {
            System.out.println("***请输入部门的编号***");
            deptno = scanner.next();
            System.out.println("***请输入部门的名称***");
            dname = scanner.next();
            System.out.println("***请输入部门的位置***");
            loc = scanner.next();
            preparedStatement = connection.prepareStatement(sql_1);
            preparedStatement.setString(1, deptno);
            preparedStatement.setString(2, dname);
            preparedStatement.setString(3, loc);
            int i = preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (i == 1) {
                System.out.println("部门添加成功");
            } else {
                System.out.println("部门添加失败");
            }
        } else if (flag == 2) {
            preparedStatement = connection.prepareStatement(sql_2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("deptno") + resultSet.getString("dname") + resultSet.getString("loc"));
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } else if (flag == 3) {
            System.out.println("请输入要删除的部门编号");
            int next = scanner.nextInt();
            preparedStatement = connection.prepareStatement(sql_3);
            preparedStatement.setInt(1, next);
            int i = preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (i == 1) {
                System.out.println("部门删除成功");
            } else {
                System.out.println("部门删除失败");
            }
        } else if (flag == 4) {
            System.out.println("***请输入部门的名称***");
            dname = scanner.next();
            System.out.println("***请输入部门的位置***");
            loc = scanner.next();
            System.out.println("***请输入部门的编号***");
            deptno = scanner.next();
            preparedStatement = connection.prepareStatement(sql_4);
            preparedStatement.setString(1, dname);
            preparedStatement.setString(2, loc);
            preparedStatement.setInt(3, Integer.valueOf(deptno));
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (i == 1) {
                System.out.println("部门更新成功");
            } else {
                System.out.println("部门更新失败");
            }
        } else {
            System.out.println("请输入有效操作");
        }
    }
}
