package zrc.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
    Serializable接口起到标识的作用，如果想对对象实现序列化和反序列化，需要实现此接口，这个标志接口是给Java
虚拟机参考的，java虚拟机看到这个接口后，会为该类生成一个序列化版本号。
    建议将序列化版本号手动写出来，不建议自动生成
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) {
        Bean bean = new Bean(1, "法外狂徒-张三");
        Bean bean1 = new Bean(2, "乱臣贼子-李四");
        Bean bean2 = new Bean(3, "天纵奇材-赵六");
        ArrayList<Bean> arrayList = new ArrayList<>();
        arrayList.add(bean);
        arrayList.add(bean1);
        arrayList.add(bean2);
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("F:\\StudyFile\\objectSTest"));
            outputStream.writeObject(arrayList);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
