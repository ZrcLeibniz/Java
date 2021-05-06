package rich.zrc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rich.zrc.bean.Person;
import rich.zrc.config.MainConfig;

public class RichTest {
    // 使用配置文件为Spring容器注册组件
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    // 使用注解为Spring容器注册组件，将bean标签替换为方法
    @Test
    public void testII() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = application.getBean("person", Person.class);
        // 通过类型得到容器中中组件的id
        String[] beanNamesForType = application.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        System.out.println(person);
    }

    // 使用注解为Spring容器注册组件，使用注解的方式来进行包扫描
    @Test
    public void testIII() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfig.class);
        // 得到容器中所有组件的id
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
