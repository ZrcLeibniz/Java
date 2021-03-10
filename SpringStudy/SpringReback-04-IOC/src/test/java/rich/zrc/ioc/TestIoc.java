package rich.zrc.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rich.zrc.service.BookService;
import rich.zrc.service.UserService;

public class TestIoc {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        userService.save();
        bookService.save();
    }
}
