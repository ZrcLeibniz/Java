package rich.zrc.v1.p;

import java.io.*;
import java.net.Socket;

public class RequestResponseTask implements Runnable{
    private final Socket socket;

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("一条TCP连接已经建立");
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream);
            PrintWriter printWriter = new PrintWriter(writer);
            Thread.sleep(10000);
            printWriter.printf("HTTP/1.0 200 OK\r\n");
            printWriter.printf("content-Type:text/html;charset=utf-8\r\n");
            printWriter.printf("\r\n");
            printWriter.printf("<h1>正常工作了</h1>");
            printWriter.flush();
            System.out.println("一条TCP连接已经释放");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace(System.out);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
