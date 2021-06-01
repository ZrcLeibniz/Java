package rich.zrc.socketTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 作为TCP的被动连接方。需要监听一个固定端口
        // 端口是随意选择，只要该端口目前没有被占用

        // 下面的语句完成后，TCP端口就完成了LISTEN
        ServerSocket serverSocket = new ServerSocket(8080);

        // 当前socket代表已经建立好的一条tcp连接
        // 三次握手已经结束了
        // 我们向操作系统索要一条建立好的连接，否则直到有客户端来建立连接
        Socket socket = serverSocket.accept();
        System.out.println("有一条TCP连接已经建立");

        // socket关联的TCP连接已经建立，我们作为应用层，正常的进行数据通信即可

        // 我们可以通过inputStream读取客户端发送过来的数据
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        String line = scanner.nextLine();
        System.out.println(line);

        // 我们可以通过outputStream将数据响应回客户端
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        PrintWriter writer = new PrintWriter(outputStreamWriter);
        writer.printf("今天的任务不简单\r\n");
        writer.flush();
        // 开始触发Tcp的四次挥手过程
        socket.close();
    }
}
