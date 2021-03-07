package ie.ul.cs4227.Bass.Service.RentalCommand;

import ie.ul.cs4227.Bass.Entity.Rental;

public interface Command {
	
	Boolean execute(Rental r);
}

