package rich.zrc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
    自动装配:
        Spring利用依赖注入，完成对IOC容器中各个组件的依赖关系赋值
 */
@ComponentScan(value = {"rich.zrc.dao", "rich.zrc.service", "rich.zrc.controller"})
@Configuration
public class MyConfigAutowired {

}
