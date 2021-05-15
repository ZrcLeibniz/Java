package rich.zrc.dao;

import rich.zrc.pojo.Problem;
import rich.zrc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemDao {
    public int insert(Problem problem) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        int result = 0;
        try {
            String sql = "insert into oj_table values(null, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, problem.getTitle());
            statement.setString(2, problem.getLevel());
            statement.setString(3, problem.getDescription());
            statement.setString(4, problem.getTemplateCode());
            statement.setString(5, problem.getTestCode());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
        return result;
    }

    public int delete(int id) {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from oj_table where id = ?";
        PreparedStatement statement = null;
        int result = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
        return result;
    }

    public int update(Problem problem) {
        return 0;
    }

    public List<Problem> selectAll() {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select id, title, level from oj_table";
        List<Problem> result = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Problem problem = new Problem();
                problem.setId(resultSet.getInt("id"));
                problem.setTitle(resultSet.getString("title"));
                problem.setLevel(resultSet.getString("level"));
                result.add(problem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return result;
    }

    public Problem selectOne(int problemId) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Problem result = new Problem();
        String sql = "select * from oj_table where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, problemId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result.setId(resultSet.getInt("id"));
                result.setTitle(resultSet.getString("title"));
                result.setLevel(resultSet.getString("level"));
                result.setDescription(resultSet.getString("description"));
                result.setTemplateCode(resultSet.getString("templateCode"));
                result.setTestCode(resultSet.getString("testCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return result;
    }

//    public static void main(String[] args) {
//        Problem problem = new Problem();
//        problem.setId(6);
//        problem.setTitle("两数之和");
//        problem.setLevel("简单");
//        problem.setDescription("给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 \n" +
//                "\n" +
//                " 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 \n" +
//                "\n" +
//                " \n" +
//                "\n" +
//                " 示例: \n" +
//                "\n" +
//                " 给定 nums = [2, 7, 11, 15], target = 9\n" +
//                "\n" +
//                "因为 nums[0] + nums[1] = 2 + 7 = 9\n" +
//                "所以返回 [0, 1]\n" +
//                " \n" +
//                " Related Topics 数组 哈希表 \n");
//        problem.setTemplateCode("class Solution {\n" +
//                "    public static int[] twoSum(int[] nums, int target) {\n" +
//                "    }\n");
//        problem.setTestCode("public static void main(String[] args) {\n" +
//                "        Solution solution = new Solution();\n" +
//                "        int[] arr = {2, 7, 11, 5};\n" +
//                "        int[] result = solution.twoSum(arr, 9);\n" +
//                "        if (result.length == 2 && result[0] == 0 && result[1] == 1) {\n" +
//                "            System.out.println(\"case OK\");\n" +
//                "        } else {\n" +
//                "            System.out.println(\"case error\");\n" +
//                "        }\n" +
//                "    }");
//        ProblemDao problemDao = new ProblemDao();
//        problemDao.insert(problem);
//        problemDao.delete(problem);
//        List<Problem> problems = problemDao.selectAll();
//        for (Problem problem1 : problems) {
//            System.out.println(problem1);
//        }
//        Problem problem1 = problemDao.selectOne(2);
//        System.out.println(problem1);
//    }
}
