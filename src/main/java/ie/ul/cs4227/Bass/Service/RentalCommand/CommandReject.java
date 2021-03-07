package ie.ul.cs4227.Bass.Service.RentalCommand;

public class CommandReject implements Requirer{

	private Receiver receiver;
	
	public CommandReject(Receiver receiver) {
		this.receiver = receiver;
	}
	public void execute() {
		receiver.reject(0);
	}
}
