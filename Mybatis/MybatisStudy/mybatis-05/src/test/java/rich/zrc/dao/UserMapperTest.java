package rich.zrc.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.mapper.UserMapper;
import rich.zrc.pojo.Users;
import rich.zrc.utils.MybatisUtil;

import java.util.List;

public class UserMapperTest {
    @Test
    public void testUserMapper() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Users> userAll = mapper.getUserAll();
        for (Users users : userAll) {
            System.out.println(users);
        }
    }
}
