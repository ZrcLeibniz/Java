package rich.zrc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rich.zrc.config.MyConfigProfile;

public class RichTestV {
    /*
        如何切换运行时profile的环境
            1.使用命令行动态参数，在虚拟机参数位置加载_Dspring.profiles.active=test
            2.使用代码的方式
     */
    @Test
    public void test() {
        // 1.使用无参构造器，创建一个applicationContext
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext();
        // 2.设置需要激活的环境
        application.getEnvironment().setActiveProfiles("test", "dev");
        // 3.注册主配置类
        application.register(MyConfigProfile.class);
        // 4.启动刷新容器
        application.refresh();
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
