package zrc.io.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/*
    服务端群聊系统实现
 */
public class Server {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 9999;

    public Server() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        try{
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey sk = iterator.next();
                    if (sk.isAcceptable()) {
                        SocketChannel socketChannel = (SocketChannel) sk.channel();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {
                        // 处理这个客户端的消息，接受后然后转发
                        readClientData(sk);
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readClientData(SelectionKey sk) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) sk.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = socketChannel.read(buffer);
            if (count > 0) {
                buffer.flip();
                String msg = new String(buffer.array(), 0, buffer.remaining());
                System.out.println("接收到了客户端消息:" + msg);
                sendMsgToAllClient(msg, socketChannel);
            }
        } catch (Exception e) {
            try {
                System.out.println("有人离线了" + socketChannel.getRemoteAddress());
                sk.cancel();
                assert socketChannel != null;
                socketChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void sendMsgToAllClient(String msg, SocketChannel socketChannel) {
        System.out.println("开始转发这个消息" + Thread.currentThread().getName());
        for (SelectionKey key : selector.keys()) {
            Channel channel = key.channel();
            if (channel != socketChannel && channel instanceof SocketChannel) {
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                try {
                    ((SocketChannel)channel).write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.listen();
    }
}
