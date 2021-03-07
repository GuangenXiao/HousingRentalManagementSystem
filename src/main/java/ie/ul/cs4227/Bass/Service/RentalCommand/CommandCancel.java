package ie.ul.cs4227.Bass.Service.RentalCommand;

public class CommandCancel implements Requirer{

	private Receiver receiver;
	
	public CommandCancel(Receiver receiver) {
		this.receiver = receiver;
	}
	public void execute() {
		receiver.cancel(0);
	}
	
}
