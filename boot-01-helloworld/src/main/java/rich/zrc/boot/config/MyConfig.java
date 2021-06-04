package rich.zrc.boot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import rich.zrc.boot.bean.Car;
import rich.zrc.boot.bean.Pet;
import rich.zrc.boot.bean.User;
/*
    对于当前容器而言，在容器内部是没有xml配置的组件的，我们需要使用特定的注解来讲这些组件加入到容器中
 */
@ImportResource(locations = "classpath:beans.xml")
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(Car.class)
/*
    1.配置类里面使用@Bean标注在方法上给容器中注册组件，默认是单实例的
    2.配置类本身也是一个组件
    3.proxyBeanMethods: 代理bean的方法
        Full(proxyBeanMethods = true)
            外部无论对配置类中这个组件注册方法调用多少次获取的都是之前注册到容器中的单实例对象
        Lite(proxyBeanMethods = false)
        ·配置类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断
        ·配置类组件之间有依赖关系，方法会被调用得到之前的单实例组件，用Full模式
    4.@Import({User.class, DBHelp.class}--给容器中自动创建出这两个类型的组件
    5.@CondationalOnBean: 可以标注在方法上，也可以直接标注在一个配置里类上，用来限制一个组件和整个配置类里的组件
 */
public class MyConfig {
    @Bean
    public Pet petII() {
        return new Pet("Tomcat");
    }

    @Bean
    // 当容器中存在petII组件时，才会为我们注册这个组件
    @ConditionalOnBean(name = "petII")
    public User userI() {
        User user = new User("张三", 12);
        user.setPet(petII());
        return user;
    }
}
