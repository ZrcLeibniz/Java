package zrc.principle.singleresponsibility;

public class SingleResponsibility_01 {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.run("Ħ�г�");
		vehicle.run("����");
		vehicle.run("�ɻ�");
	}
}

// Υ���˵�һְ��ԭ��һ����ͨ�����࣬�е������ֲ�ͬ���з�ʽ�Ľ�ͨ���ߵ�ְ��
// �Ľ�������ͨ������������з�ʽ��ͬ��ֳ�3����
class Vehicle {
	public void run(String vehile) {
		System.out.println(vehile + "�ڹ�·�����С�����");
	}
}