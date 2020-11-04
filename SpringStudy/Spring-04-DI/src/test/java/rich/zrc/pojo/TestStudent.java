package rich.zrc.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    @Test
    public void testCreteStudent() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    @Test
    public void testP(){
        ApplicationContext context = new ClassPathXmlApplicationContext("UserBean.xml");
        User userP = context.getBean("userP",User.class);
        System.out.println(userP);
        User userC = context.getBean("userC", User.class);
        System.out.println(userC);
    }
}
