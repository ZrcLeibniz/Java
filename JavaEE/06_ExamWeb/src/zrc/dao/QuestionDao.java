package zrc.dao;

import zrc.entity.Question;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QuestionDao {
    public int add(Question question, HttpServletRequest request) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ServletContext servletContext = request.getServletContext();
        Map map = (Map) servletContext.getAttribute("key");
        int result = 0;
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            connection = (Connection) iterator.next();
            boolean flag = (boolean) map.get(connection);
            if (flag) {
                map.put(connection, false);
                break;
            }
        }
        try {
            String sql = "insert into question(title, optionA, optionB, optionC, optionD, answer) values (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, question.getTitle());
            preparedStatement.setString(2, question.getOptionA());
            preparedStatement.setString(3, question.getOptionB());
            preparedStatement.setString(4, question.getOptionC());
            preparedStatement.setString(5, question.getOptionD());
            preparedStatement.setString(6, question.getAnswer());
            result = preparedStatement.executeUpdate();
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
            map.put(connection, true);
        }
        return result;
    }

    public List<Question> select(HttpServletRequest request) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ServletContext application = request.getServletContext();
        Map map = (Map) application.getAttribute("key");
        Iterator iterator = map.keySet().iterator();
        ArrayList<Question> arrayList = new ArrayList<>();
        while (iterator.hasNext()) {
            connection = (Connection) iterator.next();
            boolean flag = (boolean) map.get(connection);
            if (flag) {
                map.put(connection, false);
                break;
            }
        }
        String sql = "SELECT * FROM question";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int questionId = resultSet.getInt("questionId");
                String title = resultSet.getString("title");
                String optionA = resultSet.getString("optionA");
                String optionB = resultSet.getString("optionB");
                String optionC = resultSet.getString("optionC");
                String optionD = resultSet.getString("optionD");
                String answer = resultSet.getString("answer");
                Question question = new Question(questionId, title, optionA, optionB, optionC, optionD, answer);
                arrayList.add(question);
            }
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            map.put(connection, true);
        }
        return arrayList;
    }

    public int delete(int questionId, HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        Map map = (Map) application.getAttribute("key");
        Iterator iterator = map.keySet().iterator();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;
        String sql = "delete from question where questionId = ?";
        while (iterator.hasNext()) {
            connection = (Connection) iterator.next();
            boolean flag = (boolean) map.get(connection);
            if (flag) {
                map.put(connection, false);
                break;
            }
        }
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, questionId);
            result = preparedStatement.executeUpdate();
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
            map.put(connection, true);
        }
        return result;
    }

    public Question find(int questionId, HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Map map = (Map) application.getAttribute("key");
        Iterator iterator = map.keySet().iterator();
        String sql = "select * from question where questionId = ?";
        Question question = new Question();
        while (iterator.hasNext()) {
            connection = (Connection) iterator.next();
            boolean flag = (boolean) map.get(connection);
            if (flag) {
                map.put(connection, false);
                break;
            }
        }
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, questionId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                question.setQuestionId(resultSet.getInt("questionId"));
                question.setTitle(resultSet.getString("title"));
                question.setOptionA(resultSet.getString("optionA"));
                question.setOptionB(resultSet.getString("optionB"));
                question.setOptionC(resultSet.getString("optionC"));
                question.setOptionD(resultSet.getString("optionD"));
                question.setAnswer(resultSet.getString("answer"));
            }
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            map.put(connection, true);
        }
        return question;
    }

    public int update(Question question, HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;
        Map map = (Map) application.getAttribute("key");
        Iterator iterator = map.keySet().iterator();
        String sql = "update question set title=?, optionA=?, optionB=?, optionC=?, optionD=?, answer=? where questionID=?";
        while (iterator.hasNext()) {
            connection = (Connection) iterator.next();
            boolean flag = (boolean) map.get(connection);
            if (flag) {
                map.put(connection, false);
                break;
            }
        }
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, question.getTitle());
            preparedStatement.setString(2, question.getOptionA());
            preparedStatement.setString(3, question.getOptionB());
            preparedStatement.setString(4, question.getOptionC());
            preparedStatement.setString(5, question.getOptionD());
            preparedStatement.setString(6, question.getAnswer());
            preparedStatement.setInt(7, question.getQuestionId());
            result = preparedStatement.executeUpdate();
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
            map.put(connection, true);
        }
        return result;
    }
}
