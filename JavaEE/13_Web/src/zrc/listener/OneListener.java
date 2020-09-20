package zrc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("恭喜恭喜，来世走一遭");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("兄弟莫怕，再走一遭便是");
    }
}
