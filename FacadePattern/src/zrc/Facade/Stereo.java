package zrc.Facade;

public class Stereo {
	private static Stereo instance = new Stereo();

	public static Stereo getInstance() {
		return instance;
	}

	private Stereo() {
	}

	public void on() {
		System.out.println("灯光开机");
	}

	public void off() {
		System.out.println("灯光关机");
	}
	
}
