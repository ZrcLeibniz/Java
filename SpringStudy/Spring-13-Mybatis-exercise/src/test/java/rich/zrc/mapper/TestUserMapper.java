package rich.zrc.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rich.zrc.pojo.User;

import java.util.List;

public class TestUserMapper {
    @Test
    public void testGetUserAll() {
      ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> userAll = userMapper.getUserAll();
        for (User user : userAll) {
            System.out.println(user);
        }
    }
}
