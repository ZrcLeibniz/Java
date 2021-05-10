package rich.zrc.bean;

public class Car {
    public Car() {
        System.out.println("Car 创建");
    }

    public void init() {
        System.out.println("Car初始化");
    }

    public void destroy() {
        System.out.println("Car销毁");
    }
}
