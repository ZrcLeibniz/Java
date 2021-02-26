package zrc.course.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect01 {
    public static void main(String[] args) throws Exception {
        // 使用反射创建对象
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        Person tom = constructor.newInstance("Tom", 12);
        System.out.println(tom);
        // 通过反射调用指定属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(tom, 10);
        System.out.println(tom);
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(tom);
        // 通过反射可以调用Person类的私有构造器
        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person jerry = declaredConstructor.newInstance("Jerry");
        System.out.println(jerry);
        // 通过反射调用Person类的私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jerry, "猪八戒");
        System.out.println(jerry);
        // 通过反射调用Person的私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(jerry, "高老庄");
        System.out.println(nation);
    }
}
