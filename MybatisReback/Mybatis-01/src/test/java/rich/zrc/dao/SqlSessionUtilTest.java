package rich.zrc.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.Student;
import rich.zrc.utils.SqlSessionUtil;

import java.util.List;

public class SqlSessionUtilTest {
    @Test
    public void test() {
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<Student> students = mapper.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }
}
