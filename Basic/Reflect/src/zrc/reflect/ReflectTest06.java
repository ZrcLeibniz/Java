package zrc.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
通过反射机制获取Java源码
 */
public class ReflectTest06 {
    public static void main(String[] args) throws ClassNotFoundException {
        StringBuilder s = new StringBuilder();
        Class studentClass = Class.forName("java.lang.String");
        s.append(Modifier.toString(studentClass.getModifiers()) + " class " + studentClass.getSimpleName() + "{");
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field field : declaredFields) {
            s.append("\n");
            s.append("\t");
            s.append(Modifier.toString(field.getModifiers()));
            s.append(" ");
            s.append(field.getType().getSimpleName());
            s.append(" ");
            s.append(field.getName());
            s.append(";");
        }
        s.append("\n");
        s.append("}");
        System.out.println(s);
    }
}
