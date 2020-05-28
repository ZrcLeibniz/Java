package zrc.principle.singleresponsibility;

public class SingleResponsibility_01 {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.run("摩托车");
		vehicle.run("汽车");
		vehicle.run("飞机");
	}
}

// 违反了单一职责原则，一个交通工具类，承担了三种不同运行方式的交通工具的职责
// 改进：将交通工具类根据运行方式不同拆分成3个类
class Vehicle {
	public void run(String vehile) {
		System.out.println(vehile + "在公路上运行。。。");
	}
}