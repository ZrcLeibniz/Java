package zrc.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest08 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class serviceClass = Class.forName("zrc.reflect.service.UserService");
        // 获取所有的method
        Method[] methods = serviceClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType().getSimpleName());
            System.out.println(Modifier.toString(method.getModifiers()));
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class parameterType: parameterTypes) {
                System.out.println(parameterType);
            }
            System.out.println(method);
        }
    }
}
