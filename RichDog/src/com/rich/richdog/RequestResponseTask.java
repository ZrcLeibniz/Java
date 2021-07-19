package com.rich.richdog;

import com.rich.standar.Servlet;
import com.rich.standar.http.HttpServletRequest;
import com.rich.standar.http.HttpServletResponse;

import java.net.Socket;

public class RequestResponseTask implements Runnable {
    private final Socket socket;

    public RequestResponseTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
//        // 1.解析请求并得到一个请求对象
//        HttpServletRequest request = null;
//        // 2.实例化一个响应对象
//        HttpServletResponse response = null;
//        // 3.根据request.getContextPath()找到哪个Context进行处理
//        Context context = null;
//        // 4.根据request.getServletPath()找到Context中的Servlet进行处理
//        Servlet servlet = null;
//        // 5.调用servlet.service(request, response)，交给业务处理
//        servlet.service(request, response);
//        // 6.根据response对象中的数据，发送Http响应
//        sendResponse(response);
    }
}
