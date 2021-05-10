package rich.zrc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 通过实现接口的方式，来定义初始化和销毁逻辑
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("Cat构造");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }
}
