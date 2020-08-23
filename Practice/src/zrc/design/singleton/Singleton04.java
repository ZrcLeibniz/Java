package zrc.design.singleton;

/*
双重检查
 */
public class Singleton04 {
    private static volatile Singleton04 INSTANCE;

    private Singleton04() {
    }

    public static Singleton04 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton04.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton04();
                }
            }
        }
        return INSTANCE;
    }
}
