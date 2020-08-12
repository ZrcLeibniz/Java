package zrc.reflect;

import zrc.reflect.bean.Student;

import java.lang.reflect.Field;

/*
通过反射机制访问一个Java对象的属性
    给属性赋值
    获取属性的值
 */
public class ReflectTest07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class studentClass = Class.forName("zrc.reflect.bean.Student");
        Object o = studentClass.newInstance();
        Field no = studentClass.getDeclaredField("no");
        no.set(o, 2019);
        System.out.println(no.get(o));
        // 如果被访问的属性是私有的，可以使用filed.setAccessible(true);打破封装
    }
}
