package rich.zrc.mapper;

import rich.zrc.pojo.User;

import java.util.List;

public interface UserMapper {
    User queryUser(int id);

    User queryUser2(int id);
}
