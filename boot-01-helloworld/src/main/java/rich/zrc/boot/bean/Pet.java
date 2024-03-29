package rich.zrc.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private String name;
    private Double weight;

    public Pet(String name) {
        this.name = name;
    }
}
