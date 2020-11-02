package rich.zrc.daoImpl;

import rich.zrc.dao.UserDao;

public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Mysql获取用户数据");
    }
}
