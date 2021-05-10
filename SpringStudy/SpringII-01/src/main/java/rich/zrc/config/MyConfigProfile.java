package rich.zrc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
    Profile:
        Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
        例如: 生产环境、开发环境、测试环境
        当该注解在bean上时，指定组件在哪个环境中才会回注册到容器中
        加了环境标识的bean只有这个环境被激活的时候才能注册到容器中
        默认使用default环境，如果profile中的value是default，会被默认注册到Spring容器中
        当该注解在类上时，只有环境是指定环境时，这个配置类中的组件才会生效
 */
@PropertySource(value = "classpath:/db.properties")
@Configuration
public class MyConfigProfile {
    @Value("${user}")
    private String user;
    @Value("${driverClass}")
    private String driverClass;

    @Profile(value = "dev")
    @Bean(value = "testDataSource")
    public DataSource dataSourceDev(@Value("${password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ssm");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile(value = "dev")
    @Bean(value = "devDataSource")
    public DataSource dataSourceTest(@Value("${password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/exam of study");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile(value = "app")
    @Bean(value = "AppDataSource")
    public DataSource dataSourceApp(@Value("${password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/exam");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
}
