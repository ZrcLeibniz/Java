package rich.zrc.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import rich.zrc.pojo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentDaoTest {
    @Test
    public void selectStudentAll() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            List<Student> students = studentDao.selectStudents();
            for (Student student : students) {
                System.out.println(student);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertStudent() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("Mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            StudentDao mapper = sqlSession.getMapper(StudentDao.class);
            Student student = new Student(10001, "张某", 1, 1);
            int num = mapper.insertStudent(student);
            System.out.println(num);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
