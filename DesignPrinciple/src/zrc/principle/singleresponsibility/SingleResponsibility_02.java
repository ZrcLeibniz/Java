package zrc.principle.singleresponsibility;

public class SingleResponsibility_02 {
	public static void main(String[] args) {
		RoadVehicle roadVehicle = new RoadVehicle();
		AirVehicle AirVehicle = new AirVehicle();
		RiverVehicle riverVehicle = new RiverVehicle();
		roadVehicle.run("摩托车");
		AirVehicle.run("飞机");
		riverVehicle.run("轮船");
	}
}

// 遵守了单一职责原则，按照不同的运行方式都交通工具类进行拆分
// 但是这样做的改动很大，即将类分解后，同时需要修改客户端
// 改进方案：直接修改Vehicle类，改动的代码比较少
class RoadVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle+"在路上跑");
	}
}

class AirVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle+"在天上跑");
	}
}

class RiverVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle+"在水上跑");
	}
}