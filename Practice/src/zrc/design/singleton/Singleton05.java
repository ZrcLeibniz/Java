package zrc.design.singleton;
/*
静态内部类方式
 */
public class Singleton05 {
    private Singleton05() {
    }

    private static class Singleton {
        private final static Singleton05 INSTANCE = new Singleton05();
    }

    public static Singleton05 getInstance() {
        return Singleton.INSTANCE;
    }
}
