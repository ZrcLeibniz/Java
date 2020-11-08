package rich.zrc.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rich.zrc.config.RichConfig;

public class JavaConfigTest {
    @Test
    public void testJavaConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RichConfig.class);
        User user = applicationContext.getBean("getUser", User.class);
        System.out.println(user);
    }
}
