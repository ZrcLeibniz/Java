package rich.zrc.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOCIII {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextIII.xml");
        RichMan richMan = applicationContext.getBean("richMan", RichMan.class);
        System.out.println(richMan);
        PersonII person = applicationContext.getBean("person", PersonII.class);
        System.out.println(person);
    }
}
