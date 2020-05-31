package zrc.Facade;

public class HomeThreateFacade {
	private DVDPlayer DVD;
	private Popcorn popcorn;
	private Stereo stereo;
	private Projector projector;
	private Screen screen;
	private Light light;

	public HomeThreateFacade() {
		super();
		this.DVD = DVD.getInstance();
		this.popcorn = Popcorn.getInstance();
		this.stereo = Stereo.getInstance();
		this.projector = Projector.getInstance();
		this.screen = Screen.getInstance();
		this.light = Light.getInstance();
	}

	public void ready() {
		popcorn.on();
		popcorn.play();
		screen.on();
		projector.on();
		stereo.on();
		DVD.on();
		light.on();
	}
	
	public void play() {
		DVD.play();
	}
	
	public void end() {
		popcorn.off();
		screen.off();
		projector.off();
		stereo.off();
		DVD.off();
		light.off();
	}
	
}
