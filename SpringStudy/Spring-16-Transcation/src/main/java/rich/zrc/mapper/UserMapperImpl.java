package rich.zrc.mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import rich.zrc.pojo.User;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public List<User> getUserAll() {
        return getSqlSession().getMapper(UserMapper.class).getUserAll();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
