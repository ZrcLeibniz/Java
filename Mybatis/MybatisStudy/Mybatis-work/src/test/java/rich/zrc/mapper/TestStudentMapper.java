package rich.zrc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.Student;
import rich.zrc.utils.MybatisUtils;

import java.util.List;

public class TestStudentMapper {
    @Test
    public void testGetStudentAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentAll = mapper.getStudentAll();
        for (Student student : studentAll) {
            System.out.println(student);
        }
    }
}
