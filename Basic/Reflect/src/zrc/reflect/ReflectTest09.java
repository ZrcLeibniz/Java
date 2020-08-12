package zrc.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
通过反射机制调用方法
 */
public class ReflectTest09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> serviceClass = Class.forName("zrc.reflect.service.UserService");
        Object o = serviceClass.newInstance();
        Method login = serviceClass.getDeclaredMethod("login", String.class, String.class);
        Object admin = login.invoke(o, "admin", "123");
        System.out.println(admin);
    }
}
