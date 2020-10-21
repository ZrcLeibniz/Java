package rich.zrc.mapper;

import org.apache.ibatis.annotations.*;
import rich.zrc.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserAll();

    @Select("select * from user")
    List<User> getUserAll2();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{pwd})")
    int addUser(User user);

    @Update("update user set name = #{name}, pwd = #{pwd} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}
