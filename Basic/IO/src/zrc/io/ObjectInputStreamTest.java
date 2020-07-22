package zrc.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
如果在将对象序列化的过程，不想序列化某个属性，可以在属性前加上transient关键字表示游离的
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) {
        ObjectInputStream fileInputStream = null;
        try {
            fileInputStream = new ObjectInputStream(new FileInputStream("F:\\StudyFile\\objectSTest"));
            Object o = fileInputStream.readObject();
            System.out.println(o.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
