package zrc.commandpattern;

public class RemoteController {
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand;

	public RemoteController() {
		onCommands = new Command[5];
		offCommands = new Command[5];
		for (int i = 0; i < 5; i++) {
			onCommands[i] = new NoCommand();
			offCommands[i] = new NoCommand();
		}
	}

	public void setCommand(int no, Command onCommand, Command offCommand) {
		onCommands[no] = onCommand;
		offCommands[no] = offCommand;
	}

	public void onButton(int no) {
		onCommands[no].execute();
		undoCommand = onCommands[no];
	}

	public void offButton(int no) {
		offCommands[no].execute();
		undoCommand = offCommands[no];
	}

	public void undoButton() {
		undoCommand.undo();
	}

}
