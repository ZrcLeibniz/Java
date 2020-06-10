package zrc.observer;

public class BaiduSite implements Observer{

	private float temperature;
	private float presure;
	private float humidity;

	@Override
	public void updata(float temperature, float presure, float humidity) {
		this.temperature = temperature;
		this.presure = presure;
		this.humidity = humidity;
		display();
	}

	public void display() {
		System.out.println("***Today BaiduTemperature:" + temperature + "***");
		System.out.println("***Today Baidupresure:" + presure + "***");
		System.out.println("***Today Baiduhumidity:" + humidity + "***");
	}

}
