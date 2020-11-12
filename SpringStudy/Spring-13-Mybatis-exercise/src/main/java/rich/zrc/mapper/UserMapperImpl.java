package rich.zrc.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import rich.zrc.pojo.User;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getUserAll() {
        return sqlSession.getMapper(UserMapper.class).getUserAll();
    }
}
