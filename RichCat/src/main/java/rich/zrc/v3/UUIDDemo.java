package rich.zrc.v3;

import java.util.UUID;

public class UUIDDemo {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        System.out.println(s);
    }
}
