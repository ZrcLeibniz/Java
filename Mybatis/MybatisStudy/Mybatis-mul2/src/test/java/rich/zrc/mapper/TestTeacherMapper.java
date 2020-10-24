package rich.zrc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.Teacher;
import rich.zrc.utils.MybatisUtil;

import java.util.List;

public class TestTeacherMapper {
    @Test
    public void testGetTeacherAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherAll = mapper.getTeacherAll();
        for (Teacher teacher : teacherAll) {
            System.out.println(teacher);
        }
    }

    @Test
    public void testGeTeacherById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherById = mapper.getTeacherById(1);
        System.out.println(teacherById);
    }

    @Test
    public void testGetTeacher() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
    }
}
