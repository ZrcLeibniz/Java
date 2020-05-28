package zrc.principle.singleresponsibility;

public class SingleResponsibility_03 {
	public static void main(String[] args) {
		VehiclePlus vehicle = new VehiclePlus();
		vehicle.runAir("飞机");
		vehicle.runRoad("汽车");
		vehicle.runSea("轮船");
	}
}

// 这种修改方法没有都原来的类进行大的修改，只是增加了方法
// 这种方式在类的级别上没有遵守单一职责原则，但是在方法的级别上还是遵守单一责制原则
class VehiclePlus {
	public void runRoad(String vehile) {
		System.out.println(vehile + "在公路上运行。。。");
	}
	
	public void runAir(String vehile) {
		System.out.println(vehile + "在天空上运行。。。");
	}
	
	public void runSea(String vehile) {
		System.out.println(vehile + "在大海上运行。。。");
	}
}