package rich.zrc.mapper;

import rich.zrc.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> getUserAll();

    public int addUser(User user);

    public int deleteUser(int id);
}
