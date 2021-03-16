package rich.zrc.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rich.zrc.impl.MyMathCalculator;
import rich.zrc.impl.MyMathCalculatorII;
import rich.zrc.inter.Calculator;

public class TestAOP {
    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        /* 细节一：
                从ioc容器中拿到目标对象，注意：如果想用类型，一定要使用其接口类型
                AOP的底层就是动态代理，容器中保存的是它的代理对象
         */
        // class com.sun.proxy.$Proxy22
        Calculator myMathCalculator = (Calculator) ioc.getBean("myMathCalculator");
        System.out.println(myMathCalculator.getClass());
//        myMathCalculator.add(1, 1);
        // class rich.zrc.impl.MyMathCalculatorII$$EnhancerBySpringCGLIB$$b726fd4b
        MyMathCalculatorII myMathCalculatorII = ioc.getBean("myMathCalculatorII", MyMathCalculatorII.class);
        myMathCalculatorII.add(1, 1);
        System.out.println(myMathCalculatorII.getClass());
    }
}
