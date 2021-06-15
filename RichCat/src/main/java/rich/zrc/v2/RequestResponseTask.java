package rich.zrc.v2;


import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestResponseTask implements Runnable {
    private final Socket socket;
    private static final String DOC_BASE = "E:/GitWarehouse/Java/RichCat/docBase";
    private static final Map<String, String> mimeTypeMap = new HashMap<>();
    static {
        mimeTypeMap.put("txt", "text/plain");
        mimeTypeMap.put("html", "text/html");
        mimeTypeMap.put("js", "application/javascript");
        mimeTypeMap.put("jpg", "image/jpeg");
    }

    RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            System.out.println("一条TCP连接已经建立");
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            scanner.next();
            String path = scanner.next();
            System.out.println(path);
            if (path.equals("/")) {
                path = "/index.html";
            }
            String filePath = DOC_BASE + path;
            // 1.判断该文件是否存在
            File resource = new File(filePath);
            if (resource.exists()) {
                // 读取文件内容并写入response body中
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);
                String contentType = "text/plain";
                if (path.contains(".")) {
                    int i = path.lastIndexOf(".");
                    String suffix = path.substring(i + 1);
                    contentType = mimeTypeMap.getOrDefault(suffix, contentType);
                }
                if (contentType.startsWith("text/")) {
                    contentType = contentType + ";charset=utf-8";
                }
                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("Content-Type:%s\r\n", contentType);
                printWriter.printf("\r\n");
                printWriter.flush();
                // 写入body部分
                try (InputStream resourceInputStream = new FileInputStream(resource)) {
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int read = resourceInputStream.read(buffer);
                        if (read == -1) {
                            break;
                        }
                        outputStream.write(buffer, 0, read);
                    }
                    outputStream.flush();
                }
            } else {
                // response 404
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);
                printWriter.printf("HTTP/1.0 404 Not Found\r\n");
                printWriter.printf("Content-Type:text/html;charset=utf-8\r\n");
                printWriter.printf("\r\n");
                printWriter.printf("<h1>%s, 对应资源不存在<h1>", path);
                printWriter.flush();
                System.out.println("一条TCP连接已经释放");
            }
        } catch (IOException e) {
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
