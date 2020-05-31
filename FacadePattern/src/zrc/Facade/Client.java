package zrc.Facade;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeThreateFacade homeThreateFacade = new HomeThreateFacade();
		homeThreateFacade.ready();
		homeThreateFacade.play();
		homeThreateFacade.end();
	}

}
