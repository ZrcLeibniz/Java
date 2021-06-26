package zrc.io.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("data01.txt");
            FileChannel channel = outputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("Hello rich".getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

