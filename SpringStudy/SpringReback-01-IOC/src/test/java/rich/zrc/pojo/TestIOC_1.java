package rich.zrc.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 实验1:根据IOC容器创建对象，并为属性赋值
public class TestIOC_1 {
    /*
    从容器中拿到组件
    ApplicationContext这个接口有两个具体的实现类:
        ClassPathXApplicationContext: 当Spring的配置文件放在类路径下，使用这个实现类
        FileSystemXmlApplicationContext: 当Spring的配置文件放在磁盘路径下，使用这个实现类
     */
    @Test
    public void testPerson() {
        // ApplicationContext既是我们所说的Spring容器
        // bean的创建在容器的创建过程中就已经完成了
        // 同一个组件在IOC容器中是但单例的
        // 利用反射中的newInstance()方法调用无参构造方法，然后使用set的方法给对象赋值
        // javaBean的属性名是由什么决定的: 是由getter/setter方法决定的，去掉set，后面的字母全部小写
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    // 实验1:根据IOC容器创建对象，并为对象赋值
    // 当我们只创建IOC容器时，就已经调用了Pig的无参构造方法，说明在IOC容器创建的过程中就已经创建了IOC中的Bean
    // 而Pig的构造方法在打印语句之前执行，说明只有创建所有的Bean之后，IOC容器才会创建成功
    // 说明IOC在构建Bean的过程中是使用Pig的无参构造方法
    // 说明在创建对象的过程中已经调用了set方法为对象的方法赋值
    @Test
    public void testPig() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        System.out.println("IOC容器创建成功");
    }

    // 在此方法中，将setName方法的名字修改为setPigName
    // 此时，ioc.xml文件中的property标签报错
    // 说明Spring在设置属性的时候，属性标签的name属性是由set的名称方法决定的
    // 例如:setName -> name setPigName -> pigName
    @Test
    public void testPigII() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Object pig = applicationContext.getBean("pig");
    }

    // 在IOC容器中每个Bean的实例默认只有一份
    @Test
    public void testPigIII() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Object pig = applicationContext.getBean("pig");
        Object pig1 = applicationContext.getBean("pig");
        System.out.println(pig == pig1);
    }
}
