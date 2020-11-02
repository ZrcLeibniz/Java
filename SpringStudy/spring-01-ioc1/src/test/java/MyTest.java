import org.junit.Test;
import rich.zrc.daoImpl.UserDaoImpl;
import rich.zrc.daoImpl.UserDaoMysqlImpl;
import rich.zrc.daoImpl.UserDaoOracleImpl;
import rich.zrc.serviceImpl.UserServiceImpl;

public class MyTest {
    @Test
    public void test() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
