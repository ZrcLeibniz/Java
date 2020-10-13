package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import zrc.dao.UserMapper;
import zrc.pojo.Users;
import zrc.utils.MybatisUtils;


import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 方式一:
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Users> userList = mapper.getUserList();
        // 方式二: (不建议使用)
//        List<Users> userList = sqlSession.selectList("rich.zrc.dao.UserDao.getUserList");
        for (Users users : userList) {
            System.out.println(users);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(new Users(3, "妞妞", "111"));
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new Users(2, "妞妞", "123"));
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper =  sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(3);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
}
