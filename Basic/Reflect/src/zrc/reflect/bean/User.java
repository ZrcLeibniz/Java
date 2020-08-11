package zrc.reflect.bean;

public class User {
    public User(String s) {

    }
    static {
        System.out.println("我被加载了");
    }
    public User() {
    }
}
