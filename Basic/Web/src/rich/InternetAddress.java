package rich;

/*
通信要素一：IP和端口号
    1.IP：唯一的标识Internet上的计算机
    2.在Java中使用InetAddress类代表IP
    3.端口号与IP地址的组合得出一个网络套接字；：Socket
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetAddress {
    public static void main(String[] args) {
        try {
            // 实例化InetAddress的方法
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            // getHostAddress()获取主机地址
            System.out.println(inet2.getHostAddress());
            // getHostName()获取域名
            System.out.println(inet2.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
