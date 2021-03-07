package ie.ul.cs4227.Bass.Service.RentalCommand;

import ie.ul.cs4227.Bass.Dao.RentalDao;
import ie.ul.cs4227.Bass.Entity.Rental;

public class CommandCancel implements Command{

	private RentalDao receiver;
	
	public CommandCancel(RentalDao receiver) {
		this.receiver = receiver;
	}
	public Boolean  execute(Rental r) {
		try {
			Integer result =receiver.deteleRental(r.getrId());
			if(result>0)return true;
			else return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
}
