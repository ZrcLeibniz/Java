package rich.zrc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.Teacher;
import rich.zrc.util.MybatisUtils;

import java.util.List;

public class TestTeacherMapper {
    @Test
    public void testGetTeacherAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherAll = mapper.getTeacherAll();
        for (Teacher teacher : teacherAll) {
            System.out.println(teacher);
        }
    }
}
