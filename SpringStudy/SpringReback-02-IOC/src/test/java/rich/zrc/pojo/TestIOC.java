package rich.zrc.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
    @Test
    public void test1() {
        ConfigurableApplicationContext resource = new ClassPathXmlApplicationContext("applicationContext.xml");
        Pig pig = resource.getBean("pig", Pig.class);
        System.out.println(pig);
        resource.close();
    }
}
