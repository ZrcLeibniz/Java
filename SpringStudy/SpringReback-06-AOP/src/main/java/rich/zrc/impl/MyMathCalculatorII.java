package rich.zrc.impl;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;


@Service
public class MyMathCalculatorII {
    public int add(int i, int j) {
        return i + j;
    }

    public int sub(int i, int j) {
        return i - j;
    }

    public int mul(int i, int j) {
        return i * j;
    }

    public int div(int i, int j) {
        return i / j;
    }
}
