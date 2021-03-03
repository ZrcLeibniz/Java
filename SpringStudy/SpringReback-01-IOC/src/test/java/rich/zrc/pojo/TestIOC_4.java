package rich.zrc.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class TestIOC_4 {
    @Test
    // 将对象的某一属性赋值为null
    public void testAllProperties() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("IOC2.xml");
        PersonII personPlusIII = (PersonII) applicationContext.getBean("personPlusIII");
        List<Pig> farm = personPlusIII.getFarm();
        for (Pig pig : farm) {
            System.out.println(pig);
        }
        Map<PersonII, PersonII> marry = personPlusIII.getMarry();
        Set<PersonII> personIIS = marry.keySet();
        Iterator<PersonII> iterator = personIIS.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Collection<PersonII> values = marry.values();
        System.out.println(values);
        Properties properties = personPlusIII.getProperties();
        System.out.println(properties);
    }
}
