package zrc.io.bio.three;

import zrc.io.bio.two.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            HandlerSocketServerPool handlerSocketServerPool = new HandlerSocketServerPool(6, 10);
            while (true) {
                Socket socket = serverSocket.accept();
                ServerRunnable serverRunnable = new ServerRunnable(socket);
                handlerSocketServerPool.execute(serverRunnable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
