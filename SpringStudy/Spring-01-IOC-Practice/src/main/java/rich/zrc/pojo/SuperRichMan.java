package rich.zrc.pojo;

import java.util.Map;

public class SuperRichMan {
    private String name;
    private String gender;
    private int age;
    private Car car;
    private Map<String, Integer> house;
    private Airplane airplane;

    public SuperRichMan() {
    }

    public SuperRichMan(String name, String gender, int age, Car car, Map<String, Integer> house, Airplane airplane) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.car = car;
        this.house = house;
        this.airplane = airplane;
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

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @Override
    public String toString() {
        return "SuperRichMan{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", house=" + house +
                ", airplane=" + airplane +
                '}';
    }
}
