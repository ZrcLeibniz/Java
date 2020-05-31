package zrc.Facade;

public class Screen {
	private static Screen instance = new Screen();

	public static Screen getInstance() {
		return instance;
	}

	private Screen() {
	}

	public void on() {
		System.out.println("��Ļ����");
	}

	public void off() {
		System.out.println("��Ļ�ػ�");
	}
}
