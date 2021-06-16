package rich.zrc.v3;

import java.io.Serializable;

public class Pojo implements Serializable {
    private int id;
    private String username;
    private String gender;

    public Pojo() {
    }

    public Pojo(int id, String username, String gender) {
        this.id = id;
        this.username = username;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
