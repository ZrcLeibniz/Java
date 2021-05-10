package rich.zrc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rich.zrc.bean.Car;
import rich.zrc.bean.Cat;
import rich.zrc.bean.Dog;
import rich.zrc.config.MainConfigOfLifeCycle;

public class RichTestIII {
    @Test
    public void test() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        Car car = application.getBean("car", Car.class);
        application.close();
    }

    @Test
    public void testII() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        Cat cat = application.getBean("cat", Cat.class);
        System.out.println(cat);
        application.close();
    }

    @Test
    public void testIII() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        Dog dog = application.getBean("dog", Dog.class);
        System.out.println(dog);
        application.close();
    }

    @Test
    public void testIV() {

    }
}
