package rich.zrc.v3;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws IOException {
        Pojo u1 = new Pojo(1, "rich", "男");
        Pojo u2 = new Pojo(2, "张三", "女");
        String fileName = "E:\\GitWarehouse\\Java\\RichCat\\session\\pojo.obj";
        try (OutputStream outputStream = new FileOutputStream(fileName)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(u1);
            objectOutputStream.writeObject(u2);
            objectOutputStream.flush();
        }
    }
}
