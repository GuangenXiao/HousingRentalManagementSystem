package ie.ul.cs4227.Bass.Service.TopupStrategy;

import ie.ul.cs4227.Bass.Entity.User;

public class StrategyFactory {
	private static TopUpStrategy user = new UserTopUpStrategy(); 
	private static TopUpStrategy admin = new AdminTopUpStrategy(); // No topup function
	private static TopUpStrategy owner = new OwnerTopUpStrategy(); 

	public static TopUpStrategy getStrategy(User u) {
		if(u.getuType()==null)return admin;
		if(u.getuType().equals("admin")) {
			return admin;
		}else if(u.getuType().equals("owner")) {
			return  owner;
		}else if(u.getuType().equals("user")) {
			return user;
		}else {
			return admin;
		}
	}
}
