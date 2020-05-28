package zrc.principle.singleresponsibility;

public class SingleResponsibility_02 {
	public static void main(String[] args) {
		RoadVehicle roadVehicle = new RoadVehicle();
		AirVehicle AirVehicle = new AirVehicle();
		RiverVehicle riverVehicle = new RiverVehicle();
		roadVehicle.run("Ħ�г�");
		AirVehicle.run("�ɻ�");
		riverVehicle.run("�ִ�");
	}
}

// �����˵�һְ��ԭ�򣬰��ղ�ͬ�����з�ʽ����ͨ��������в��
// �����������ĸĶ��ܴ󣬼�����ֽ��ͬʱ��Ҫ�޸Ŀͻ���
// �Ľ�������ֱ���޸�Vehicle�࣬�Ķ��Ĵ���Ƚ���
class RoadVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle+"��·����");
	}
}

class AirVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle+"��������");
	}
}

class RiverVehicle {
	public void run(String vehicle) {
		System.out.println(vehicle+"��ˮ����");
	}
}