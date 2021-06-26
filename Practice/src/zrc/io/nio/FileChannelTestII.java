package zrc.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTestII {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("data01.txt");
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer);
            byteBuffer.flip();
            String result = new String(byteBuffer.array(), 0, byteBuffer.remaining());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
