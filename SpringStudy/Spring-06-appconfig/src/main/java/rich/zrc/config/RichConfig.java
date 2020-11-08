package rich.zrc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import rich.zrc.pojo.User;

@Configuration
@ComponentScan("rich.zrc.pojo")
public class RichConfig {
    @Bean
    public User getUser() {
        return new User();
    }
}
