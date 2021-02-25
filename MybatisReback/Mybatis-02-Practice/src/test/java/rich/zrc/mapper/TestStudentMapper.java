package rich.zrc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.Student;
import rich.zrc.util.SqlSessionUtil;

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
    }

    @Test
    public void testSelectStudentById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectStudentById(1);
        System.out.println(student);
    }
}
