package zrc.design.singleton;
/*
通过加锁来解决线程不安全问题
 */
public class Singleton03 {
    private static Singleton03 INSTANCE;

    private Singleton03() {
    }

    public static synchronized Singleton03 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }
}
