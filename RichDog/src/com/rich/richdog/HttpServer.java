package com.rich.richdog;

import com.rich.standar.ServletException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    public static final String WEBAPPS_BASE = "E:\\GitWarehouse\\Java\\RichDog\\webapps";
    private static final List<Context> contextList = new ArrayList<>();
    private static final ConfigReader configReader = new ConfigReader();

    public static void main(String[] args) {
        // 1.找到所有的Servlet对象进行初始化
        initServer();
        // 2.每次循环处理一个请求
        try {
            startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 3.找到所有的Servlet对象进行销毁
        destroyServer();
    }

    private static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while (true) {
            Socket socket = serverSocket.accept();
            Runnable task = new RequestResponseTask(socket);
            threadPool.execute(task);
        }
    }

    private static void destroyServer() {
        for (Context context : contextList) {
            context.destroyServlets();
        }
    }

    private static void initServer() {
        scanContexts();
        parseContextConf();
        loadServletClasses();
        instantiateServletObjects();
        initializeServletObjects();
    }

    private static void initializeServletObjects() {
        for (Context context : contextList) {
            try {
                context.initializeServletObjects();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }

    private static void instantiateServletObjects() {
        for (Context context : contextList) {
            try {
                context.instantiateServletObjects();
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private static void loadServletClasses() {
        for (Context context : contextList) {
            try {
                context.loadServletClasses();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static void parseContextConf() {
        for (Context context : contextList) {
            try {
                context.readConfigFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


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
            Context context = new Context(configReader, contextName);
            contextList.add(context);
        }
    }
}
