package rich.zrc;

import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven {
    @Test
    public void testAdd() {
        System.out.println("===testAdd方法执行了===");
        HelloMaven helloMaven = new HelloMaven();
        int add = helloMaven.add(110, 20);
        Assert.assertEquals(130, add);
    }

    @Test
    public void testAdd2() {
        System.out.println("===testAdd2方法执行了===");
        HelloMaven helloMaven = new HelloMaven();
        int add = helloMaven.add(110, 20);
        Assert.assertEquals(130, add);
    }
}
