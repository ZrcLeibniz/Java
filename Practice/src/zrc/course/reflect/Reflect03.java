package zrc.course.reflect;

import java.util.Random;

public class Reflect03 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        Person o = (Person) clazz.newInstance();
        System.out.println(o);
        String classPath = "";
        int num = new Random().nextInt(3);
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "zrc.course.reflect.Person";
                break;
        }
        try {
            Object instance = getInstance(classPath);
            System.out.println(instance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object getInstance(String path) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(path);
        return clazz.newInstance();
    }
}
