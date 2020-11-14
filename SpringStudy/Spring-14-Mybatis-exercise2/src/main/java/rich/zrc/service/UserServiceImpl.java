package rich.zrc.service;

import org.mybatis.spring.SqlSessionTemplate;
import rich.zrc.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getUserAll() {
        return sqlSession.getMapper(UserService.class).getUserAll();
    }
}
