package rich.zrc.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import rich.zrc.pojo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentMapperTest {
    @Test
    public void selectAll() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectAll();
            for (Student student : students) {
                System.out.println(student);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
