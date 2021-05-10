package rich.zrc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rich.zrc.bean.Person;
import rich.zrc.config.MyConfigAutowired;
import rich.zrc.config.MyConfigProperty;

public class RichTestIV {
    // 测试使用@Value注解为组件属性赋值
    @Test
    public void test() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MyConfigProperty.class);
        Person person = application.getBean("person", Person.class);
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(person);
    }

    // 测试使用@Autowired注解
    @Test
    public void testII() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MyConfigAutowired.class);
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
