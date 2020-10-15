package rich.zrc.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import rich.zrc.pojo.Users;
import rich.zrc.utils.MybatisUtil;

import java.util.List;

public class TestUserMapper {

    static Logger logger = Logger.getLogger(TestUserMapper.class);

    @Test
    public void testGetUserAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Users> userAll = mapper.getUserAll();
        for (Users users : userAll) {
            System.out.println(users);
        }
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }
}
