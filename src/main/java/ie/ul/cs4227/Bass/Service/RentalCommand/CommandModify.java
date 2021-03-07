package ie.ul.cs4227.Bass.Service.RentalCommand;

import ie.ul.cs4227.Bass.Dao.RentalDao;
import ie.ul.cs4227.Bass.Entity.Rental;

public class CommandModify implements Command{

	private RentalDao receiver;
	
	public CommandModify(RentalDao receiver) {
		this.receiver = receiver;
	}
	
	public Boolean  execute(Rental r) {
		try {
			Integer result =receiver.updateRental(r);
			if(result>0)return true;
			else return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
