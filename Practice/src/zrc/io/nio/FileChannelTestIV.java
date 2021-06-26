package zrc.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTestIV {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("data01.txt");
        FileChannel channelIn = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("data02.txt");
        FileChannel channelOut = fileOutputStream.getChannel();
        ByteBuffer byteBufferI = ByteBuffer.allocate(4);
        ByteBuffer byteBufferII = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers = {byteBufferI, byteBufferII};
        channelIn.read(buffers);
        for (ByteBuffer buffer : buffers) {
            buffer.flip();
        }
        channelOut.write(buffers);
    }
}
