package zrc.commandpattern;

public class LightOnCommand implements Command{
	LightReceiver light;
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.on();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		light.off();
	}

	public LightOnCommand(LightReceiver light) {
		super();
		this.light = light;
	}

}
