package zrc.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
反射Student类中所有的Field
 */
public class ReflectTest05 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取整个类
        Class studentClass = Class.forName("zrc.reflect.bean.Student");
        // 获取类中所有被public修饰的Field
        Field[] fields = studentClass.getFields();
//        System.out.println(fields.length);
        Field f = fields[0];
        String name = f.getName();
//        System.out.println(name);
        // 获取类中所有的Field
        Field[] declaredFields = studentClass.getDeclaredFields();
        for(Field field:declaredFields) {
            System.out.println(Modifier.toString(field.getModifiers()));
            System.out.println(field.getType().getSimpleName());
            System.out.println(field.getName());
            System.out.println(field);
        }
    }
}
