package rich.zrc.pojo;

public class User {
    private String name;

//    public User() {
//        System.out.println("无参构造方法创建对象");
//    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
