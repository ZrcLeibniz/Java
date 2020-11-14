package rich.zrc.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rich.zrc.pojo.User;
import rich.zrc.service.UserService;

import java.util.List;

public class TestSpring {
    @Test
    public void testGetUserAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserService userServiceImpl = context.getBean("userServiceImpl", UserService.class);
        List<User> userAll = userServiceImpl.getUserAll();
        for (User user : userAll) {
            System.out.println(user);
        }
    }
}
