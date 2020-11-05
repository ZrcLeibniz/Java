package rich.zrc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Cat {
    public void shout() {
        System.out.println("miao");
    }
}
