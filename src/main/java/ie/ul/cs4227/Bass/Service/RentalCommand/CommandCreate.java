package ie.ul.cs4227.Bass.Service.RentalCommand;

import ie.ul.cs4227.Bass.Dao.RentalDao;
import ie.ul.cs4227.Bass.Entity.Rental;

public class CommandCreate implements Command{

	private RentalDao receiver;
	
	public CommandCreate(RentalDao receiver) {
		this.receiver = receiver;
	}
	public Boolean execute(Rental r) {
		try {
			Integer result =receiver.insertRental(r);
			if(result>0)return true;
			else return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
