package rich.zrc.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rich.zrc.impl.MyMathCalculator;
import rich.zrc.inter.Calculator;

public class TestAOP {
    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator myMathCalculator = (Calculator) ioc.getBean("myMathCalculator");
        myMathCalculator.add(1, 1);
    }
}
