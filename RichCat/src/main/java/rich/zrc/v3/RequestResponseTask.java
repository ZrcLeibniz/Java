package rich.zrc.v3;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
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

    @Override
    public void run() {
        try {
            System.out.println("一条TCP连接已经建立");
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            scanner.next();
            String path = scanner.next();
            scanner.nextLine();
            String requestURI = path;
            String queryString = "";
            if (path.contains("?")) {
                int i = path.indexOf("?");
                requestURI = path.substring(0, i);
                queryString = path.substring(i + 1);
            }
            Map<String, String> headers = new HashMap<>();
            String headerLine = null;
            while (scanner.hasNextLine() && !(headerLine = scanner.nextLine()).isEmpty()) {
                String[] part = headerLine.split(":");
                String name = part[0].trim().toLowerCase();
                String value = part[1].trim().toLowerCase();
                headers.put(name, value);
            }
            if (requestURI.equals("/")) {
                requestURI = "/index.html";
                path = "/index.html";
            }
            if (requestURI.equals("/set-cookie")) {
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);
                printWriter.printf("HTTP/1.0 307 Temporary Redirect\r\n");
                printWriter.printf("Set-Cookie: username=rich");
                printWriter.printf("\r\n");
                printWriter.printf("Location: /profile\r\n");
                printWriter.printf("\r\n");
                printWriter.flush();
            } else if (requestURI.equals("/profile")) {
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);
                String username = null;
                String cookie = headers.getOrDefault("cookie", "");
                System.out.println(cookie);
                for (String cookieKV : cookie.split(";")) {
                    if (cookieKV.isEmpty()) {
                        continue;
                    }
                    String[] kv = cookieKV.split("=");
                    String cookieName = kv[0];
                    String cookieValue = kv[1];
                    if (cookieName.equals("username")) {
                        username = cookieValue;
                    }
                }
                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("Content-Type:text/html;charset=utf-8\r\n");
                printWriter.printf("\r\n");
                if (username != null) {
                    printWriter.printf("<h1>当前用户是: %s</h1>", username);
                } else {
                    printWriter.printf("<h1>您需要先进行登录</h1>");
                }
                printWriter.flush();
            } else if (requestURI.equals("/redirect-to")) {
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);
                printWriter.printf("HTTP/1.0 307 Temporary Redirect\r\n");
                printWriter.printf("Location:/rich.txt\r\n");
                printWriter.printf("\r\n");
                printWriter.flush();
            } else if (requestURI.equals("/goodbye.html")) {
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "utf-8");
                PrintWriter printWriter = new PrintWriter(writer);
                String target = "rich";
                for (String kv : queryString.split("&")) {
                    if (kv.isEmpty()) {
                        continue;
                    }
                    String[] part = kv.split("=");
                    String key = URLDecoder.decode(part[0], "UTF-8");
                    String value = URLDecoder.decode(part[1], "UTF-8");
                    if (key.equals("target")) {
                        target = value;
                    }
                }
                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("Content-Type:text/html;charset=utf-8\r\n");
                printWriter.printf("\r\n");
                printWriter.printf("<h1>再见 %s</h1>", target);
                printWriter.flush();
            } else {
                String filePath = DOC_BASE + requestURI;
                File resource = new File(filePath);
                if (resource.exists()) {
                    OutputStream outputStream = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(outputStream, "utf-8");
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
                    OutputStream outputStream = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(outputStream, "utf-8");
                    PrintWriter printWriter = new PrintWriter(writer);
                    printWriter.printf("HTTP/1.0 404 Not Found\r\n");
                    printWriter.printf("Content-Type:text/html;charset=utf-8\r\n");
                    printWriter.printf("\r\n");
                    printWriter.printf("<h1>%s, 对应资源不存在</h1>", path);
                    printWriter.flush();
                    System.out.println("一条TCP连接已经释放");
                }
            }
        } catch (IOException e) {
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
