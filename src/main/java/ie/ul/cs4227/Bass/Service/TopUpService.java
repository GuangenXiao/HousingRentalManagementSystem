package ie.ul.cs4227.Bass.Service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.ul.cs4227.Bass.Dao.TopUpDao;
import ie.ul.cs4227.Bass.Dao.UserDao;
import ie.ul.cs4227.Bass.Entity.Recharge;
import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Service.TopupStrategy.StrategyFactory;
@Service
public class TopUpService implements ITopUpService {

	@Autowired
	@Resource
	TopUpDao tud;
	
	@Resource
	IUserService ius = new UserService();
	
	@Override
	public Boolean TopUp(User u,Float amount,String type) {
		Boolean topUpResult =false;
		topUpResult= u.executeStrategy(tud, amount,type);
		Integer updateResult=0;
		if(topUpResult==true) {
			System.out.println("TopUp successful");
			topUpResult=false;
			User tar = new User.Builder().uId(u.getuId()).uMoney(u.getuMoney()+amount).Build();
			updateResult= ius.updateUser(tar);
			if(updateResult>0)System.out.println("Update user info successful");
		}
		return updateResult>0;
	}

	@Override
	public ArrayList<Recharge> getTopUpList() {
		// TODO Auto-generated method stub
		return tud.selectTopUpList();
	}

	@Override
	public Recharge selectTopUpById(Integer tId) {
		// TODO Auto-generated method stub
		return tud.selectTopUp(tId);
	}

}
