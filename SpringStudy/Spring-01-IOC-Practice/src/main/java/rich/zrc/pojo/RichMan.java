package rich.zrc.pojo;

import java.util.HashMap;
import java.util.Map;

public class RichMan {
    private String name;
    private String gender;
    private int age;
    private Car car;
    private Map<String, Integer> house;

    public RichMan() {
    }

    public RichMan(String name, String gender, int age, Car car, HashMap<String, Integer> house) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.car = car;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Map<String, Integer> getHouse() {
        return house;
    }

    public void setHouse(Map<String, Integer> house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "RichMan{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", house=" + house +
                '}';
    }
}
