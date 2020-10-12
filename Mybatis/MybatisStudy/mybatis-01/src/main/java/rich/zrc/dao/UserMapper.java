package rich.zrc.dao;

import rich.zrc.pojo.Users;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<Users> getUserList();

    List<Users> getUserLike(String value);

    Users getUserById(int id);

    Users getUserById2(Map<String, Object> map);

    int addUser2(Map<String, Object> map);

    int addUser(Users user);

    int updateUser(Users use);

    int deleteUser(int id);
}
