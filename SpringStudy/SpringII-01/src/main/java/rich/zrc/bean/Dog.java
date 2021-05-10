package rich.zrc.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog {
    public Dog() {
        System.out.println("Dog构建");
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog初始化");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Dog销毁");
    }
}
