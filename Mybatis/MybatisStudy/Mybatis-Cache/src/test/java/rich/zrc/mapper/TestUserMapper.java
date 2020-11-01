package rich.zrc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.User;
import rich.zrc.util.MybatisUtils;


public class TestUserMapper {
    // 一级缓存默认是开启的，只在SqlSession关闭后清空（也就是拿到链接到关闭链接这个区间段），或者手动清理缓存
    @Test
    public void testQueryUserOneCache() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User users = mapper.queryUser(1);
        System.out.println(users);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        User user = mapper.queryUser(1);
        System.out.println(user);
        System.out.println(users == user);
        sqlSession.close();
    }

    @Test
    public void testQueryUserTwoCache() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUser2(1);
        System.out.println(user);
        sqlSession.close();

        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.queryUser2(1);
        System.out.println(user1);
        System.out.println(user == user1);
        sqlSession1.close();
    }
}
