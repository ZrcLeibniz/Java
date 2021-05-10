package rich.zrc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import rich.zrc.bean.Color;
import rich.zrc.bean.ColorFactoryBean;
import rich.zrc.bean.Person;
import rich.zrc.config.MainConfigII;

import java.util.Map;

public class RichTestII {
    @Test
    public void test() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfigII.class);
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        // 此组件在Spring容器中默认是单实例的
        Person person = application.getBean("person", Person.class);
        System.out.println(person);
        Person personII = application.getBean("person", Person.class);
        System.out.println(person == personII);
    }

    @Test
    public void testII() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfigII.class);
        String[] beanNamesForType = application.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = application.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        Map<String, Person> beansOfType = application.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    public void testIII() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigII.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void testIV() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfigII.class);
//        ColorFactoryBean colorFactory = application.getBean("colorFactoryBean", ColorFactoryBean.class);
//        System.out.println(colorFactory);
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        Color color = application.getBean("colorFactoryBean", Color.class);
        System.out.println(color);
        // 虽然注册的是ColorFactoryBean，但是在实际获取的时候还是获取的是工厂制造的对象
        // 想获取工厂对象本身可以通过下述方式
        ColorFactoryBean bean = application.getBean("&colorFactoryBean", ColorFactoryBean.class);
        System.out.println(bean);
    }
}
