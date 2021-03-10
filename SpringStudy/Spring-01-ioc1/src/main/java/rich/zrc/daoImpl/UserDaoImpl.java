package rich.zrc.daoImpl;

import rich.zrc.mapper.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("默认获取数据的实现类");
    }
}
