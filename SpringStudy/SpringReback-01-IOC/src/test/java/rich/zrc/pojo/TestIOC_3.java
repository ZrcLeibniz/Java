package rich.zrc.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC_3 {
    // 实验3: 通过构造器的方式为bean对象赋值
    // 我们可以在constructor-arg标签中使用name属性来指定要赋值的属性名
    // 使用value属性来为name属性所指定的bean属性赋值
    @Test
    public void testIOCConstructor() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Object personII = applicationContext.getBean("personII");
        System.out.println(personII);
    }
}
