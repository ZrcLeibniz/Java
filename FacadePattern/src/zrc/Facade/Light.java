package zrc.Facade;

public class Light {
	private static Light instance = new Light();

	public static Light getInstance() {
		return instance;
	}

	private Light() {
	};

	public void on() {
		System.out.println("����");
	}

	public void off() {
		System.out.println("�ػ�");
	}

	public void play() {
		System.out.println("�۽�");
	}
}
