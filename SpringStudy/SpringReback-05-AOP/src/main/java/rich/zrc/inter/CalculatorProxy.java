package rich.zrc.inter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorProxy {
    public static Calculator getProxy(Calculator calculator) {
        return (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(), calculator.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName() + "方法开始执行了,使用的额参数是" + Arrays.asList(args));
                        Object invoke = method.invoke(calculator, args);
                        System.out.println("方法执行的结果是" + invoke);
                        return invoke;
                    }
                });
    }
}
