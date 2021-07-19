package com.rich.richdog;

import java.io.*;
import java.net.ServerSocket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        // 1.找到所有的Servlet对象进行初始化
        initServer();
//        // 2.每次循环处理一个请求
//        while (true) {
//            Socket socket = serverSocket.accept();
//            Runnable task = new RequestResponseTask(socket);
//            threadPool.execute(task);
//        }
//        // 3.找到所有的Servlet对象进行销毁
//        for (Servlet servlet : servlets) {
//            servlet.destroy();
//        }
    }

    private static void initServer() {
        scanContexts();
        parseContextConf();
//        loadServletClasses();
//        instantiateServletObjects();
//        initializeServletObjects();
    }

    private static void parseContextConf() {
        for (Context context : contextList) {
            String fileName = String.format("%s/%s/WEB-INF/web.conf", WEBAPPS_BASE, context.getName());
            String stage = "start";
            try (InputStream is = new FileInputStream(fileName)) {
                Scanner scanner = new Scanner(is, "utf-8");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (line.isEmpty() || line.startsWith("#")) {
                        continue;
                    }
                    switch (stage) {
                        case "start":
                            if (line.equals("servlets:")) {
                                stage = "servlets";
                            }
                            break;
                        case "servlets":
                            if (line.equals("servlet-mapping:")) {
                                stage = "mapping";
                            } else {
                                String[] parts = line.split("=");
                                String servletName = parts[0].trim();
                                String servletClassName = parts[1].trim();
                                context.servletNameToClassName.put(servletName, servletClassName);
                            }
                            break;
                        case "mapping":
                            String[] parts = line.split("=");
                            String servletName = parts[0].trim();
                            String servletClassName = parts[1].trim();
                            context.urlToServletNameMap.put(servletName, servletClassName);
                            break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(context.servletNameToClassName);
            System.out.println(context.urlToServletNameMap);
        }
    }

    private static final String WEBAPPS_BASE = "E:\\GitWarehouse\\Java\\RichDog\\webapps";
    private static final List<Context> contextList = new ArrayList<>();

    private static void scanContexts() {
        File webappsRoot = new File(WEBAPPS_BASE);
        File[] files = webappsRoot.listFiles();
        if (files == null) {
            throw new RuntimeException();
        }
        for (File file : files) {
            if (!file.isDirectory()) {
                continue;
            }
            String contextName = file.getName();
            Context context = new Context(contextName);
            contextList.add(context);
        }
    }
}
