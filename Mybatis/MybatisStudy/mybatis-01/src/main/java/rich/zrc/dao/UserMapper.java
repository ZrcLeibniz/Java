package rich.zrc.dao;

import rich.zrc.pojo.Users;

import java.util.List;

public interface UserMapper {
    List<Users> getUserList();

    Users getUserById(int id);

    int addUser(Users user);

    int updateUser(Users use);

    int deleteUser(int id);
}
