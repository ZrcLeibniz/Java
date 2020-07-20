package zrc.io;

import java.io.*;

public class DataOutputAndInputStreamTest {
    public static void main(String[] args) {
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("F:\\StudyFile\\data"));
            dataInputStream = new DataInputStream(new FileInputStream("F:\\StudyFile\\data"));
            byte b = 100;
            short s = 200;
            int i = 300;
            long l = 400;
            float f = 3.14f;
            double d = 3.141;
            boolean o = false;
            char c = 'a';
            dataOutputStream.writeByte(b);
            dataOutputStream.writeShort(s);
            dataOutputStream.writeInt(i);
            dataOutputStream.writeLong(l);
            dataOutputStream.writeFloat(f);
            dataOutputStream.writeDouble(d);
            dataOutputStream.writeBoolean(o);
            dataOutputStream.writeChar(c);
            byte b1 = dataInputStream.readByte();
            short s1 = dataInputStream.readShort();
            int i1 = dataInputStream.readInt();
            long l1 = dataInputStream.readLong();
            float f1 = dataInputStream.readFloat();
            double d1 = dataInputStream.readDouble();
            boolean o1 = dataInputStream.readBoolean();
            char c1 = dataInputStream.readChar();
            System.out.println(b1);
            System.out.println(i1);
            System.out.println(l1);
            System.out.println(f1);
            System.out.println(d1);
            System.out.println(o1);
            System.out.println(c1);
            System.out.println(s1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
