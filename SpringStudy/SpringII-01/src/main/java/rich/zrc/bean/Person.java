package rich.zrc.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    /*
        使用@Value赋值:
            1.基本数值
            2.SpEl #{}
            3.${}
            4.
     */
    @Value("张三")
    private String name;
    @Value("#{20 - 2}")
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Value("${nickName}")
    private String nickName;

    public Person(String name, Integer age, String nickName) {
        this.name = name;
        this.age = age;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
