package rich.zrc.mapper;

import rich.zrc.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserAll();

    int addUser(User user);

    List<User> getUserByLimit(Map<String, Integer> map);
}
