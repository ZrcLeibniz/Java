package rich.zrc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Dog {
    public void shout() {
        System.out.println("wang");
    }
}
