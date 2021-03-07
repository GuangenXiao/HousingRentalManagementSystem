package ie.ul.cs4227.Bass.Service.RentalCommand;

public class CommandModify implements Requirer{

	private Receiver receiver;
	
	public CommandModify(Receiver receiver) {
		this.receiver = receiver;
	}
	
	public void execute() {
		receiver.modify(0);
	}
}
