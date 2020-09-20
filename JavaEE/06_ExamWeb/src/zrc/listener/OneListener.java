package zrc.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 在Tomcat启动的时候预先创建20个Connection
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String username = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");
        HashMap map = new HashMap<>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 20; i++) {
            try {
                Connection con = DriverManager.getConnection(url, username, password);
                System.out.println("在Http服务器启动的时候创建了一个Connection" + con);
                map.put(con, true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ServletContext application = servletContextEvent.getServletContext();
        application.setAttribute("key", map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        Map map = (Map) application.getAttribute("key");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Connection connection = (Connection) iterator.next();
            if (connection != null) {
                try {
                    System.out.println("我去了");
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
