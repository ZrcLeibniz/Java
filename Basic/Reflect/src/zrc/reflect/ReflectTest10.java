package zrc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
反射调用构造方法
 */
public class ReflectTest10 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> userClass = Class.forName("zrc.reflect.bean.User");
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class, int.class);
        Object o = declaredConstructor.newInstance(1, "张三", 1);
        System.out.println(o);
    }
}
