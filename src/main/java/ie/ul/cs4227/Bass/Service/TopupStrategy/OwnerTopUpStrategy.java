package ie.ul.cs4227.Bass.Service.TopupStrategy;

import ie.ul.cs4227.Bass.Dao.TopUpDao;
import ie.ul.cs4227.Bass.Entity.Recharge;
import ie.ul.cs4227.Bass.Entity.User;

public class OwnerTopUpStrategy implements TopUpStrategy {

	@Override
	public boolean doOperation(User u,TopUpDao tud , float amount,String Type) {
		// TODO Auto-generated method stub
		Recharge r= new Recharge.Builder().tMoney(amount).tPayType(Type).tUId(u.getuId()).Build();
		Integer result = tud.topUp(r);
		return result>0?true:false;
	}

}
