package zrc.Facade;

public class Projector {
	private static Projector instance = new Projector();

	public static Projector getInstance() {
		return instance;
	}

	private Projector() {
	};

	public void on() {
		System.out.println("投影仪开机");
	}

	public void off() {
		System.out.println("投影仪关机");
	}

	public void play() {
		System.out.println("投影仪聚焦");
	}
}
