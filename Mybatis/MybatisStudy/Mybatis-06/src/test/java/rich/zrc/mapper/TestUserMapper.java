package rich.zrc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.User;
import rich.zrc.util.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserMapper {
    @Test
    public void testAddUser() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(6, "宁海静", "111"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetUserAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userAll = mapper.getUserAll();
        for (User user : userAll) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testGetUserByLimit() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user);
        }
    }
}
