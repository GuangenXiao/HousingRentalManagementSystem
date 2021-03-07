package ie.ul.cs4227.Bass.Service.RentalCommand;

import ie.ul.cs4227.Bass.Dao.RentalDao;
import ie.ul.cs4227.Bass.Entity.Rental;

public class CommandDelete implements Command{

	private RentalDao receiver;
	
	public CommandDelete(RentalDao receiver) {
		this.receiver = receiver;
	}
	@Override
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
