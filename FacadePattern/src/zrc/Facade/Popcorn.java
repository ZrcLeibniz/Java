package zrc.Facade;

public class Popcorn {
	private static Popcorn instance = new Popcorn();

	public static Popcorn getInstance() {
		return instance;
	}

	private Popcorn() {
	}

	public void on() {
		System.out.println("爆米花开机");
	}

	public void off() {
		System.out.println("爆米花关机");
	}

	public void play() {
		System.out.println("正在爆爆米花");
	}
}
