package rich.zrc.pojo;

public class RichMan {
    private String lastName;
    private Integer age;
    private String gender;
    private String email;
    private Car car;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    @Override
    public String toString() {
        return "RichMan{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", car=" + car +
                '}';
    }

    public RichMan() {
    }

    public RichMan(String lastName, Integer age, String gender, String email, Car car) {
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.car = car;
    }

    public RichMan(Car car) {
        System.out.println("调用了构造器");
        this.car = car;
    }
}
