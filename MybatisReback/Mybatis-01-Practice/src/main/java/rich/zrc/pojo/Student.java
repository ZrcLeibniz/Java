package rich.zrc.pojo;

public class Student {
    int id;
    String name;
    int age;
    int tid;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", tid=" + tid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Student() {
    }

    public Student(int id, String name, int age, int tid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tid = tid;
    }
}
