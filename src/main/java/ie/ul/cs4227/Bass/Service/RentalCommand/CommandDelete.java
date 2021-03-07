package ie.ul.cs4227.Bass.Service.RentalCommand;

public class CommandDelete implements Requirer{

	private Receiver receiver;
	
	public CommandDelete(Receiver receiver) {
		this.receiver = receiver;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.delete(0);
	}

	
}
