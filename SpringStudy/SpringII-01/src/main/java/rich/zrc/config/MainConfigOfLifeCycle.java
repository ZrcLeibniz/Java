package rich.zrc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rich.zrc.bean.Car;
import rich.zrc.bean.Cat;
import rich.zrc.bean.Dog;

/*
    bean的生命周期:
        bean的创建 --- 初始化 --- 销毁
    我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候，来调用我们自定义的初始化或销毁方法
    构造:
        单实例:在容器启动的时候创建对象
        多实例:在每次获取的时候创建对象
    1) 指定初始化/销毁方法
        在xml配置文件中，对于某一个bean来指定"init-method="和"destroy-method"
        在bean标签中，指定initMethod=和destroyMethod=
        初始化: 对象创建好，并赋值结束，调用初始化方法
        销毁: 单实例下，容器关闭执行销毁方法，多实例下，容器不会管理这个bean
    2) 通过让Bean实现InitializingBean接口(定义初始化逻辑)和DisposableBean接口(定义销毁逻辑)
    3) 使用@PostConstruct注解和@PreDestroy注解来指定初始化和销毁逻辑
    4) Spring提供的组件BeanPostProcessor: bean的后置处理器
        在bean初始化前后进行一些处理工作
        postProcessBeforeInitialization: 在初始化之前工作
        postProcessAfterInitialization: 在初始化之后工作
 */
@Configuration
public class MainConfigOfLifeCycle {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

    @Bean
    public Cat cat() {
        return new Cat();
    }

    @Bean
    public Dog dog() {
        return new Dog();
    }
}
