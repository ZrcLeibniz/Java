package zrc.interfaceadapter;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbsAdapter absAdapter = new AbsAdapter() {
			@Override
			public void m1() {
				// TODO Auto-generated method stub
				System.out.println("ʹ����m1����");
			}
		};
		absAdapter.m1();
	}

}
