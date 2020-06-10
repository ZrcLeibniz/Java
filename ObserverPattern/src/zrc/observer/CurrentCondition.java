package zrc.observer;

public class CurrentCondition implements Observer{
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
		System.out.println("***Today mTemperature:" + temperature + "***");
		System.out.println("***Today mpresure:" + presure + "***");
		System.out.println("***Today mhumidity:" + humidity + "***");
	}

}
