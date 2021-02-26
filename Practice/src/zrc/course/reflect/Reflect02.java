package zrc.course.reflect;

// 获取class实例的方法
public class Reflect02 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 方式一：调用运行时类的属性
        Class<Person> clazz = Person.class;
        // 方式二：通过运行时类的对象
        Person p1 = new Person();
        Class<? extends Person> clazzII = p1.getClass();
        // 方式三：调用Class的静态方法
        Class<Person> clazzIII = (Class<Person>) Class.forName("zrc.course.reflect.Person");
        // 第四种：适用类的加载器
        ClassLoader classLoader = Reflect02.class.getClassLoader();
        Class<?> clazzIV = classLoader.loadClass("zrc.course.reflect.Person");
    }
}
