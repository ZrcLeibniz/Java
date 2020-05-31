package zrc.Facade;

public class Popcorn {
	private static Popcorn instance = new Popcorn();

	public static Popcorn getInstance() {
		return instance;
	}

	private Popcorn() {
	}

	public void on() {
		System.out.println("���׻�����");
	}

	public void off() {
		System.out.println("���׻��ػ�");
	}

	public void play() {
		System.out.println("���ڱ����׻�");
	}
}
