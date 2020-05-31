package zrc.Facade;

public class DVDPlayer {
	private static DVDPlayer instance = new DVDPlayer();

	public static DVDPlayer getInstance() {
		return instance;
	}

	private DVDPlayer() {
	}

	public void on() {
		System.out.println("DVD ON");
	}

	public void off() {
		System.out.println("DVD　　ＯＦＦ");
	}

	public void play() {
		System.out.println("窮唹。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
	}
}
