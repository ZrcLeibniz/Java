package zrc.design.factorymethod;

public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.go();
//        Plane plane = new Plane();
//        plane.go();
//        MoveAble plane = new Plane();
//        MoveAble car = new Car();
//        MoveAble moveAble = new Broom();
        Car car = (Car) new CarFactory().create();
    }
}
