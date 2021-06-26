package zrc.io.bio.file;

import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
