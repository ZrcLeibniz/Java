package zrc.design.singleton;
/*
懒汉式
达到了按需初始化的要求，但是带来线程不安全问题
 */
public class Singleton02 {
    private static Singleton02 INSTANCE;

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton02();
        }
        return INSTANCE;
    }
}
