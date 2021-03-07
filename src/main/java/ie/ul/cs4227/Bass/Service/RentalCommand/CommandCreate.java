package ie.ul.cs4227.Bass.Service.RentalCommand;

public class CommandCreate implements Requirer{

	private Receiver receiver;
	
	public CommandCreate(Receiver receiver) {
		this.receiver = receiver;
	}
	public void execute() {
		receiver.create();
	}
	
}
