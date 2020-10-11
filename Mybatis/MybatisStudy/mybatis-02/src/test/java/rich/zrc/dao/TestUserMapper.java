package rich.zrc.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.User;
import rich.zrc.utils.MybatisUtil;

import java.util.List;

public class TestUserMapper {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
