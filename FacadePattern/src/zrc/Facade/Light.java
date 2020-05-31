package zrc.Facade;

public class Light {
	private static Light instance = new Light();

	public static Light getInstance() {
		return instance;
	}

	private Light() {
	};

	public void on() {
		System.out.println("开机");
	}

	public void off() {
		System.out.println("关机");
	}

	public void play() {
		System.out.println("聚焦");
	}
}
