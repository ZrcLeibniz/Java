package rich.zrc.pojo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOCII {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextII.xml");
        ComboPooledDataSource poolDataSource = applicationContext.getBean("poolDataSource", ComboPooledDataSource.class);
        System.out.println(poolDataSource);
    }
}
