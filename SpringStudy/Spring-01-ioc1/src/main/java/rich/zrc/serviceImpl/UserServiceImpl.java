package rich.zrc.serviceImpl;

import rich.zrc.mapper.UserDao;
import rich.zrc.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    // 使用set进行动态实现值得注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
