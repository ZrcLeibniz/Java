package rich.zrc.socketTest;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // socket已经建立好连接
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.printf("今天的任务怎么样\n\r");
        printWriter.flush();
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        String s = scanner.nextLine();
        System.out.println(s);
        socket.close();
    }
}
