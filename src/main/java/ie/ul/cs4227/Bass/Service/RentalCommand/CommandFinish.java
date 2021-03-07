package ie.ul.cs4227.Bass.Service.RentalCommand;

public class CommandFinish implements Requirer{

	private Receiver receiver;
	
	public CommandFinish(Receiver receiver) {
		this.receiver = receiver;
	}
	public void execute() {
		receiver.finish(0);
	}
}
