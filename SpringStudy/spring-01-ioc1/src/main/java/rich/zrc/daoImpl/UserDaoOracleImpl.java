package rich.zrc.daoImpl;

import rich.zrc.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Oracle获得数据的实现类");
    }
}
