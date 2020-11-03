package rich.zrc.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void testCreateUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("User");
        User user1 = (User) context.getBean("user");
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user == user1);
    }
}
