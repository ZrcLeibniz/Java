package zrc.Facade;

public class Screen {
	private static Screen instance = new Screen();

	public static Screen getInstance() {
		return instance;
	}

	private Screen() {
	}

	public void on() {
		System.out.println("屏幕开机");
	}

	public void off() {
		System.out.println("屏幕关机");
	}
}
