package rich.zrc.dao;

import org.springframework.stereotype.Repository;
import rich.zrc.pojo.User;

@Repository
public class UserDao extends BaseDao<User> {
    @Override
    public void save() {
        System.out.println("保存用户");
    }
}
