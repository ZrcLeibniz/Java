package rich.zrc.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PersonII {
    private String name;
    private int age;
    private String gender;
    private String email;
    private Car car;
    private List<Pig> farm;
    private Map<PersonII, PersonII> marry;
    private Properties properties;

    public PersonII(String name, int age, String gender, String email, Car car, List<Pig> farm, Map<PersonII, PersonII> marry, Properties properties) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.car = car;
        this.farm = farm;
        this.marry = marry;
        this.properties = properties;
    }

    public List<Pig> getFarm() {
        return farm;
    }

    public void setFarm(List<Pig> farm) {
        this.farm = farm;
    }

    public Map<PersonII, PersonII> getMarry() {
        return marry;
    }

    public void setMarry(Map<PersonII, PersonII> marry) {
        this.marry = marry;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public PersonII() {
    }
}
