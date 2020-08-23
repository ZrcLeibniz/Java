package zrc.design.singleton;
/*
饿汉式
类加载到内存后，就实例化一个单例，JVM保证线程安全
缺点:不管用到与否，类装载时就完成实例化
 */
public class Singleton01 {
    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01() {}

    public static Singleton01 getInstance() {
        return INSTANCE;
    }
}
