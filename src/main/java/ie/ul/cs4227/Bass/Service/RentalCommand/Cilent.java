package ie.ul.cs4227.Bass.Service.RentalCommand;

public class Cilent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Requirer requirer = new CommandCreate(new Receiver());
		Invoker invoker = new Invoker(requirer);
		invoker.create();
		invoker.cancel();
		invoker.finish();
		invoker.reject();
		invoker.modify();
		invoker.wipe();
	}

}
