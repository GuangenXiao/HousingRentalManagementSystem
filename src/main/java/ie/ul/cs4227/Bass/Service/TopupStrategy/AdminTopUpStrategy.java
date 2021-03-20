package ie.ul.cs4227.Bass.Service.TopupStrategy;

import ie.ul.cs4227.Bass.Dao.TopUpDao;
import ie.ul.cs4227.Bass.Entity.User;

public class AdminTopUpStrategy implements TopUpStrategy {

	@Override
	public boolean doOperation(User u,TopUpDao tud , float amount,String Type) {
		return false;
	}

}
