package rich.zrc.dao;

import rich.zrc.pojo.User;

import java.util.List;


public interface UserMapper {
    List<User> selectAll();
}
