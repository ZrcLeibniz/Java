package zrc.visitor;

public class Fail extends Action{

	@Override
	public void getManResult(Man man) {
		// TODO Auto-generated method stub
		System.out.println("����ʧ��");
	}

	@Override
	public void getWomanResult(Woman woman) {
		// TODO Auto-generated method stub
		System.out.println("Ů��ʧ��");
	}

}
