package ie.ul.cs4227.Bass.Service.RentalCommand;

import ie.ul.cs4227.Bass.Dao.RentalDao;
import ie.ul.cs4227.Bass.Entity.Rental;

public class CommandFinish implements Command{

	private RentalDao receiver;
	
	public CommandFinish(RentalDao receiver) {
		this.receiver = receiver;
	}
	public Boolean  execute(Rental r) {
		return null;
		
	}
}
