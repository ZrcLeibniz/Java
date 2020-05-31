package zrc.Facade;

public class Projector {
	private static Projector instance = new Projector();

	public static Projector getInstance() {
		return instance;
	}

	private Projector() {
	};

	public void on() {
		System.out.println("ͶӰ�ǿ���");
	}

	public void off() {
		System.out.println("ͶӰ�ǹػ�");
	}

	public void play() {
		System.out.println("ͶӰ�Ǿ۽�");
	}
}
