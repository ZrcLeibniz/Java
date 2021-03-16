package rich.zrc.aop;

import org.junit.Test;
import rich.zrc.impl.MyMathCalculator;
import rich.zrc.inter.Calculator;
import rich.zrc.inter.CalculatorProxy;

public class TestCal {
    @Test
    public void test() {
        Calculator calculator = CalculatorProxy.getProxy(new MyMathCalculator());
        int add = calculator.add(1, 1);
    }
}
