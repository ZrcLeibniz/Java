package zrc.observer;

public class Client {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentCondition currentCondition = new CurrentCondition();
		weatherData.registerObserver(currentCondition);
//		weatherData.setData(10, 100, 20);
		BaiduSite baiduSite = new BaiduSite();
		weatherData.registerObserver(baiduSite);
		weatherData.setData(100, 1000, 10000);
	}
}
