package rich.zrc.v3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class SerializableDemoII {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "E:\\GitWarehouse\\Java\\RichCat\\session\\pojo.obj";
        try (InputStream inputStream = new FileInputStream(fileName)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Pojo u1 = (Pojo) objectInputStream.readObject();
            Pojo u2 = (Pojo) objectInputStream.readObject();
            System.out.println(u1);
            System.out.println(u2);
        }
    }
}
