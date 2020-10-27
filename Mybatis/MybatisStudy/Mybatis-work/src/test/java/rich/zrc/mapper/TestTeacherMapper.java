package rich.zrc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.Teacher;
import rich.zrc.utils.MybatisUtils;

public class TestTeacherMapper {
    @Test
    public void testGetTeacherById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherById = mapper.getTeacherById(1);
        System.out.println(teacherById);
    }
}
