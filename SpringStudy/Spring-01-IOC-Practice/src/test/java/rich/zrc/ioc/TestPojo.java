package rich.zrc.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rich.zrc.pojo.Car;
import rich.zrc.pojo.Person;
import rich.zrc.pojo.RichMan;
import rich.zrc.pojo.SuperRichMan;

public class TestPojo {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocI.xml");
        Person person = applicationContext.getBean("person1", Person.class);
        System.out.println(person);
        Person person2 = applicationContext.getBean("person2", Person.class);
        System.out.println(person2);
    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocI.xml");
        RichMan richman1 = applicationContext.getBean("richman1", RichMan.class);
        Car car = richman1.getCar();
        Car car1 = applicationContext.getBean("car", Car.class);
        System.out.println(car == car1);
        System.out.println(richman1);
        System.out.println(car);
        System.out.println(car1);
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("iocI.xml");
        SuperRichMan superrichman = applicationContext.getBean("superrichman", SuperRichMan.class);
        System.out.println(superrichman);
    }
}
