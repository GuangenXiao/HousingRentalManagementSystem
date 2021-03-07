package ie.ul.cs4227.Bass.Service.RentalCommand;

import ie.ul.cs4227.Bass.Dao.RentalDao;
import ie.ul.cs4227.Bass.Entity.Rental;

public class Invoker {

	private Command requirer;
	public Invoker(Command requirer) {
		this.requirer = requirer;
	}
    public Boolean call(Rental r){
        return requirer.execute(r);
    }
}
