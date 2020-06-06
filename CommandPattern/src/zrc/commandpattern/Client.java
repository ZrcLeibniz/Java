package zrc.commandpattern;

public class Client {
	public static void main(String[] args) {
		LightReceiver lightReceiver = new LightReceiver();
		LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
		LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
		RemoteController remoteController = new RemoteController();
		remoteController.setCommand(0, lightOnCommand, lightOffCommand);
		remoteController.onButton(0);
		remoteController.offButton(0);
		remoteController.undoButton();
	}
}
