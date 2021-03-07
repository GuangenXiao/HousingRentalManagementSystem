package ie.ul.cs4227.Bass.Service.RentalCommand;

import ie.ul.cs4227.Bass.Dao.RentalDao;
import ie.ul.cs4227.Bass.Entity.Rental;

public class CommandReject implements Command{

	private RentalDao receiver;
	
	public CommandReject(RentalDao receiver) {
		this.receiver = receiver;
	}
	public Boolean execute(Rental r) {
		return null;
		
	}
}
