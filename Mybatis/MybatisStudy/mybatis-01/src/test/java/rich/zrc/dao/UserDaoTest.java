package rich.zrc.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import rich.zrc.pojo.Users;
import rich.zrc.utils.MybatisUtils;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 方式一:
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<Users> userList = mapper.getUserList();
        // 方式二: (不建议使用)
//        List<Users> userList = sqlSession.selectList("rich.zrc.dao.UserDao.getUserList");
        for (Users users : userList) {
            System.out.println(users);
        }
        sqlSession.close();
    }
}
