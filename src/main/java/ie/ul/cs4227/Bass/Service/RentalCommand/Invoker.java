package ie.ul.cs4227.Bass.Service.RentalCommand;

public class Invoker {

	private Requirer requirer;
	public Invoker(Requirer requirer) {
		this.requirer = requirer;
	}
	public void create() {
		requirer.execute();
	}
    public void finish() {
    }
    public void wipe() {
    }
    public void reject() {
    }
    public void cancel() {
    }
    public void modify() {
    }
}
