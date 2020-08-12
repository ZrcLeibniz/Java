package zrc.reflect;

/*
通过一个已知的类获取这个类的父类以及实现的接口
 */
public class ReflectTest11 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("java.lang.String");
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass.getName());
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class i : interfaces) {
            System.out.println(i.getName());
        }
    }
}
