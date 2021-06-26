package zrc.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTestIII {
    public static void main(String[] args) {
        File srcFile = new File("F:\\hahaha.jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("hehe.jpg");
            FileInputStream fileInputStream = new FileInputStream(srcFile);
            FileChannel channelIn = fileInputStream.getChannel();
            FileChannel channelOut = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (true) {
                byteBuffer.clear();
                int flag = channelIn.read(byteBuffer);
                if (flag == -1) {
                    break;
                }
                byteBuffer.flip();
                channelOut.write(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
