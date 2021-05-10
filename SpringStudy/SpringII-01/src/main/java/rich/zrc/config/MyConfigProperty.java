package rich.zrc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import rich.zrc.bean.Person;

// 可以使用此注解来引入外部的资源文件
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MyConfigProperty {
    @Bean
    public Person person() {
        return new Person();
    }
}
