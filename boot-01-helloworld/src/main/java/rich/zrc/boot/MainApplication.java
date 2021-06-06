package rich.zrc.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import rich.zrc.boot.bean.Pet;
import rich.zrc.boot.bean.User;

/*
    @SpringBootApplication: 表明这是一个SpringBoot应用
    将标有此注解的类成为主程序类
 */
@SpringBootApplication()
/*
    这个注解相当于这三个注解
        @SpringBootConfiguration
            代表当前这个类是一个配置类
        @EnableAutoConfiguration
            是开启自动配置的注解
            @AutoConfigurationPackage
                @Import({Registrar.class})
                相当于写了一段代码来批量注册组件，参见Import的高级用法
                将指定的一个包下的所有组件导入(如不指定，默认就是主程序所在包下的所有组件)
            @Import({AutoConfigurationImportSelector.class})
                使用了selector机制批量导入一些组件，getAutoConfigurationEntry(annotationMetadata)获取所有自动配置的集合
                前一个方法又调用了getCandidateConfigurations(annotationMetadata, attributes)方法之后，又做了一些处理之
                后将需要导入到容器中的配置类，这个方法会利用Spring的工厂加载器，从
                spring-boot-autoconfigure-2.3.4.RELEASE.jar中的META-INF/spring-factories导入所有需要的容器
                虽然127个常用的组件都被全部加载进了容器中，但是会按需开启自动配置项，用到了@Conditional注解
                例如AopAutoConfiguration这个类，在其中标注了@ConditionalOnClass(Advice.class)
        @ComponentScan
            增加包扫描，指定需要扫描那些东西
 */
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
//        User person = run.getBean("personI", User.class);
        User userI = run.getBean("userI", User.class);
//        Pet pig = run.getBean("pig", Pet.class);
        Pet petII = run.getBean("petII", Pet.class);
//        System.out.println(person);
        System.out.println(userI);
//        System.out.println(pig);
        System.out.println(petII);
        System.out.println(userI.getPet() == petII);
    }
}
