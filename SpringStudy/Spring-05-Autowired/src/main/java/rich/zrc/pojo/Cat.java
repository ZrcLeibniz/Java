package rich.zrc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Cat {
    public void shout() {
        System.out.println("miao");
    }
}
