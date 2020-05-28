package zrc.classadapter;

public class Client {
	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.charging(new VoltageCAdapter());
	}
}
