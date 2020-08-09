package zrc.reflect;

import java.util.Date;

/*
要操作一个类的字节码，需要首先获取到这个类的字节码，三种方式
 */
public class ReflectTest01 {
    public static void main(String[] args) {
        Class c1 = null;
        try {
            /*
            Class.forName()
            1.静态方法
            2.方法的参数是一个字符串
            3.字符串必须是一个完整类名
            4.完整类名必须带有包名。
             */
            c1 = Class.forName("java.lang.String");
            Class c2 = Class.forName("java.util.Date");
            Class c3 = Class.forName("java.lang.Integer");
            Class c4 = Class.forName("java.lang.System");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
        java中任何一个对象都有一个方法叫getClass()
         */
        String s1 = "abc";
        Class c5 = s1.getClass();
        System.out.println(c1 == c5);
        /*
        java中任何一种数据类型，包括基本数据类型，它都有.class属性
         */
        Class z = String.class;
        Class x = Date.class;
        Class f = int.class;
        Class h = double.class;
        System.out.println(z == c5);
    }
}
