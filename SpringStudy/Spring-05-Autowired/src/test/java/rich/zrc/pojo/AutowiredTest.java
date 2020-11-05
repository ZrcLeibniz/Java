package rich.zrc.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("People", People.class);
        System.out.println(people);
        people.getCat().shout();
        people.getDog().shout();
    }

    @Test
    public void testAutoWireByName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("peopleByName", People.class);
        System.out.println(people);
        people.getCat().shout();
        people.getDog().shout();
    }

    @Test
    public void testAutoWireByType() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("peopleByType", People.class);
        System.out.println(people);
        people.getCat().shout();
        people.getDog().shout();
    }

    @Test
    public void testAutoWireByAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("peopleAnnotation", People.class);
        System.out.println(people);
        people.getCat().shout();
        people.getDog().shout();
    }
}
