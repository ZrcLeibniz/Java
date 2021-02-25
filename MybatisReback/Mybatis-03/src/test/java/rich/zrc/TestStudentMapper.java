package rich.zrc;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.mapper.StudentMapper;
import rich.zrc.pojo.Student;
import rich.zrc.utils.QueryParam;
import rich.zrc.utils.SqlSessionUtil;

import java.util.List;

public class TestStudentMapper {
    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectStudentById(1);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectStudentByNameAndAge() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectStudentBNameAndAge("张某", 1);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentByObject() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        QueryParam queryParam = new QueryParam("学生3", 10);
        List<Student> students = mapper.selectStudentByObject(queryParam);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}

/*
#{} 和 ${}的区别：
    #{}: 占位符-告诉mybatis使用实际的参数值替代，并使用PrepareStatement对象执行sql语句
        #{}代替的是sql语句的"?"
    ${}: 字符串替换-告诉mybatis使用$包含的字符串替换所在位置，使用Statement对象将sql语句
        和${}的内容链接起来
 */