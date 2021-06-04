package rich.zrc.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rich.zrc.boot.bean.Car;

@RestController
public class HelloController {
    @Autowired
    Car car;

    @RequestMapping("/hello")
    public String handle01() {
        return "Hello, Spring Boot 2";
    }

    @RequestMapping("/myCar")
    public Car car() {
        return car;
    }
}
/*
    了解自动配置的原理
        1.1 依赖管理
            父项目做依赖管理
                可以点击其父项目，发现父项目中几乎声明了所有开发中常用的依赖的版本号
                如果想修改版本号，可以在自己pom文件中重写properties来规定新的版本
            开发导入starter场景启动器
                spring-boot-starter-* 只要引入某个场景的starter，这个场景的所有常规依赖都会自动引入
                我们也可以自己创建一个场景启动器 *-spring-boot-starter 以这种形式出现的一般都是第三方为我们提供的场景启动器
                所有的场景启动器最底层的依赖是spring-boot-starter
            无需关注版本号，自动版本仲裁
                引入依赖默认都可以不写版本号
            可以修改版本号
       1.2 自动配置
            自动配置tomcat
                引入tomcat依赖 spring-boot starter-tomcat
                配置tomcat
            自动配置SpringMVC
                引入SpringMVC全套组件
                自动配好SpringMVC常用组件()
            自动配置Web常见问题，如字符编码等
            默认的包结构
                不需要设置包的自动扫描就可以自动进行包扫描
                其默认的扫描根目录是，主程序所在的文件夹
                如果想改变扫描的根目录可以使用配置@SpringBootApplication(scanBasePackages = "rich.zrc")
            各种配置所需的默认值
                其每一个配置的默认值最终都会对应到某一个类上
                在容器中会有这些类的实例
            按需加载所有自动配置项
                只有当我们需要某一个场景时，才会为我们加载该场景所需的依赖
 */