package rich.zrc.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 根据bean的类型从IOC容器中获取bean的实例
public class TestIOC_2 {
    @Test
    public void testPerson () {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }
}
