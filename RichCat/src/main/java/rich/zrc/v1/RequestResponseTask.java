package rich.zrc.v1;

import java.io.*;
import java.net.Socket;

public class RequestResponseTask implements Runnable {
    private final Socket socket;

    RequestResponseTask(Socket socket) {
        this.socket = socket;
    }


    public void run() {
        try {
            System.out.println("一条TCP连接已经建立");
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            PrintWriter printWriter = new PrintWriter(writer);
            Thread.sleep(10000);
            printWriter.printf("HTTP/1.0 200 OK\r\n");
            printWriter.printf("Content-Type:text/html;charset=utf-8\r\n");
            printWriter.printf("\r\n");
            printWriter.printf("<h1>正常工作了<h1>");
            printWriter.flush();
            System.out.println("一条TCP连接已经释放");
        } catch (IOException | InterruptedException e) {
            // 因为单次请求响应周期错误，不应该影响其他请求响应周期
            // 所以我们只做打印，不终止进程
            e.printStackTrace(System.out);
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
