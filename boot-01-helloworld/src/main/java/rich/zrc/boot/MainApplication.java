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
