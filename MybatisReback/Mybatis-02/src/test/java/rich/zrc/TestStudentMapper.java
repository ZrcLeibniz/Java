package rich.zrc;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.dao.StudentMapper;
import rich.zrc.pojo.Student;
import rich.zrc.utils.SqlSessionUtils;

import java.util.List;

public class TestStudentMapper {
    @Test
    public void testSelectStudents() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
