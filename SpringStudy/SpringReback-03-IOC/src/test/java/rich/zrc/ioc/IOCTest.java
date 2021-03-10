package rich.zrc.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rich.zrc.controller.RichServlet;
import rich.zrc.mapper.RichMapper;
import rich.zrc.utils.RichUtil;
import rich.zrc.service.RichService;

public class IOCTest {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RichMapper richMapper = (RichMapper) applicationContext.getBean("richMapper");
        RichUtil richUtil = (RichUtil) applicationContext.getBean("richUtil");
        RichService richService = (RichService) applicationContext.getBean("richService");
        RichServlet richServlet = (RichServlet) applicationContext.getBean("richServlet");
        System.out.println(richMapper);
        System.out.println(richService);
        System.out.println(richServlet);
        System.out.println(richUtil);
    }

    /*
    方法上有@Autowired注解，那么这个方法中的每一个形参都会自动注入，并且会在容器启动的时候自动运行这个方法
    @Autowired的装配过程:
        1.先按照类型去容器中找到对应的属性
        2.如果找到多个，拿到变量名与组件的默认id继续匹配
        3.如果因为变量名与默认id不一致导致注入失败，可以通过@Qualifier注解指定这个属性的匹配变量名来与组件的id匹配
        4.通过Autowired中的required的属性来指定无法注入的行为
            true:抛异常
            false:装配null
     */
    /*
        @Autowired @Resource @Inject
        都可以实现自动装配
        @Autowired:功能最为强大，是Spring自己的注解
        @Resource:j2EE的标准，Java自己的注解
        @Resource的扩展性比较强，如果切换成另外一个容器框架，此注解还是可以被使用，因为此注解是JDK的标准
     */
    @Test
    public void testII() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RichServlet richServlet = applicationContext.getBean("richServlet", RichServlet.class);
        richServlet.richServlet();

    }
}
