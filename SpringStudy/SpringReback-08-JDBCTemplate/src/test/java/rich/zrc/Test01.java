package rich.zrc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test01 {
    // 测试数据源
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComboPooledDataSource dataSource = (ComboPooledDataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }

    // 测试JDBCTemplate对象
    @Test
    public void testI() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
    }

    // 更新数据库中的数据
    @Test
    public void testII() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");
        String sql = "UPDATE people SET age = ? WHERE id = ?";
        int update = jdbcTemplate.update(sql, 32, 9);
        System.out.println("更新员工:" + update);
    }
}
