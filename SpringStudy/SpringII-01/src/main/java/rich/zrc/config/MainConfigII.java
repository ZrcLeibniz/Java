package rich.zrc.config;

import rich.zrc.condition.LinuxCondition;
import rich.zrc.condition.MyImportBeanDefinitionRegistrar;
import rich.zrc.condition.MyImportSelector;
import rich.zrc.condition.WindowsCondition;
import org.springframework.context.annotation.*;
import rich.zrc.bean.Color;
import rich.zrc.bean.Person;
import rich.zrc.bean.Season;

/*
    给容器中添加组件的方法:
        1.使用包扫描+组件标注注解
            对于我们自己写的类，可以使用这种方法
        2.使用@Bean注解
            第三方包里面如果没有添加@Service类似的注解，我们可以通过@Bean来注册
        3.@Import
            快速给容器中注册一个组件
            1) @Import(要导入容器的组件): 容器就会自动注册这个组件，默认的id是组件的全类名
            2) ImportSelector: 返回需要注册的组件的全类名的数组
            3) ImportBeanDefinitionRegistrar: 手动注册组件到IOC容器中
 */
@Configuration
@Import({Color.class, Season.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfigII {
    // 在Spring容器中默认是单实例的
    // 我们可以使用scope注解来指定组件的作用域
    // 当组件是单实例时，会在IOC容器加载的时候创建组件 singleton
    // 当组件是多实例时，会在获取该组件实例的时候创建组件 prototype
    /*
        懒加载：
            单实例bean默认在容器启动1的时候创建对象
            懒加载：容器启动不创建对象，第一次使用（获取）组件的时候创建对象
     */

    @Scope("singleton")
    // 让单实例组件懒加载
    @Lazy
    @Bean(value = "person")
    public Person person() {
        return new Person("李四", 18);
    }

    /*
        @Conditional: 按照一定条件进行判断，满足条件才会给容器中注册组件

        当前条件是:
            如果操作系统是windows那就就将bill加载进IOC容器
            如果操作系统是linux那就就将linus加载进IOC容器
        该注解可以放在方法上，也可以放在类上
            方法上: 满足当前条件，这个组件就可以被注册
            类上: 满足当前条件，这个配置类中的组件才会被注册
     */
    @Conditional({WindowsCondition.class})
    @Bean(value = "bill")
    public Person person01() {
        return new Person("Bill", 23);
    }

    @Conditional({LinuxCondition.class})
    @Bean(value = "linus")
    public Person person02() {
        return new Person("linus", 24);
    }
}
