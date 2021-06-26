package zrc.io.nio;

import java.nio.ByteBuffer;

public class BufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        // 获得buffer的位置
        System.out.println(byteBuffer.position());
        // 获得buffer的限制
        System.out.println(byteBuffer.limit());
        String name = "rich";
        byteBuffer.put(name.getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        char b = (char)byteBuffer.get();
        System.out.println(b);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
    }
}
