package rich.zrc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import rich.zrc.bean.Person;

// 告诉Spring这是一个配置类，在使用注解开发的过程中，这个类相当于配置文件
@Configuration
// 使用此注解来进行包扫描，其中value属性用来注定要扫描的包名
// excludeFilters = Filter[]: 指定扫描的时候按照什么规则排除组件
// includeFilters = Filter[]: 指定扫描的时候按照什么规则加入组件
//@ComponentScan(value = "rich.zrc", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//})
//@ComponentScan(value = "rich.zrc", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//}, useDefaultFilters = false)
// FilterType.ANNOTATION: 按照注解尽心过滤
// FilterType.ASSIGNABLE_TYPE: 按照给定类型进行过滤
// FilterType.ASPECTJ: 使用Aspectj表达式
// FilterType.REGEX: 使用正则表达式
// FilterType.CUSTOM: 使用自定义规则
@ComponentScan(value = "rich.zrc", includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
}, useDefaultFilters = false)
public class MainConfig {
    // 给容器中注册一个Bean;类型作为返回值的类型，id默认是方法名
    // 通过value属性为容器中的该组件设置id
    @Bean(value = "person")
    public Person person() {
        return new Person("张三", 20);
    }
}
