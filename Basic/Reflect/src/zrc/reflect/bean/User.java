package zrc.reflect.bean;

public class User {
    int no;
    String name;
    int age;

    public User(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    static {
        System.out.println("我被加载了");
    }
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
