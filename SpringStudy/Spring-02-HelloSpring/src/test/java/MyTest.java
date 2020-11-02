import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rich.zrc.pojo.Hello;

public class MyTest {
    @Test
    public void testHelloSpring() {
        // 获取Spring的上下文对象
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello) classPathXmlApplicationContext.getBean("hello");
        System.out.println(hello.toString());
    }
}
