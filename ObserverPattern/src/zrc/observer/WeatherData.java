package zrc.observer;

import java.util.ArrayList;

public class WeatherData implements Subject{
	private float temperature;
	private float presure;
	private float humidity;
	private ArrayList<Observer> observers;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPresure() {
		return presure;
	}

	public void dataChange() {
//		currentCondition.updata(getTemperature(), getPresure(), getHumidity());
		notifyObservers();
	}
	
	public void setData(float temperature, float presure, float humidity) {
		this.temperature = temperature;
		this.presure = presure;
		this.humidity = humidity;
		dataChange();
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i = 0; i < observers.size(); i++) {
			observers.get(i).updata(getTemperature(), getPresure(), getHumidity());
		}
	}
}
