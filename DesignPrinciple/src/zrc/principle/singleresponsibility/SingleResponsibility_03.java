package zrc.principle.singleresponsibility;

public class SingleResponsibility_03 {
	public static void main(String[] args) {
		VehiclePlus vehicle = new VehiclePlus();
		vehicle.runAir("�ɻ�");
		vehicle.runRoad("����");
		vehicle.runSea("�ִ�");
	}
}

// �����޸ķ���û�ж�ԭ��������д���޸ģ�ֻ�������˷���
// ���ַ�ʽ����ļ�����û�����ص�һְ��ԭ�򣬵����ڷ����ļ����ϻ������ص�һ����ԭ��
class VehiclePlus {
	public void runRoad(String vehile) {
		System.out.println(vehile + "�ڹ�·�����С�����");
	}
	
	public void runAir(String vehile) {
		System.out.println(vehile + "����������С�����");
	}
	
	public void runSea(String vehile) {
		System.out.println(vehile + "�ڴ������С�����");
	}
}