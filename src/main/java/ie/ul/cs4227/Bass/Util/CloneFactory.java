package ie.ul.cs4227.Bass.Util;

import java.util.Date;

import ie.ul.cs4227.Bass.Entity.House;
import ie.ul.cs4227.Bass.Entity.HouseType;
import ie.ul.cs4227.Bass.Entity.Recharge;
import ie.ul.cs4227.Bass.Entity.Rental;
import ie.ul.cs4227.Bass.Entity.User;

public class CloneFactory {
	public static Object DeepClone(Object obj) {
		Object result=null;
		if(obj instanceof House) {
			House h = (House)obj;
			result= cloneHouse(h);
		}else if(obj instanceof User) {
			 User h = ( User)obj;
			result= cloneUser(h);
		}else if(obj instanceof HouseType) {
			HouseType h = (HouseType)obj;
			result= cloneHouseType(h);
		}else if(obj instanceof Recharge) {
			Recharge h = (Recharge)obj;
			result= cloneRecharge(h);
		}else if(obj instanceof Rental) {
			Rental h = (Rental)obj;
			result= cloneRental(h);
		}else result=null;
		
		return result;
	}
	private static Rental cloneRental(Rental r) {
		Rental result= new Rental.Builder()
				.rId(r.getrId())
				.rHId(r.getrId())
				.rUId(r.getrUId())
				.rPrice(r.getrPrice())
				.rStart(r.getrStart())
				.rEnd(r.getrEnd())
				.rDeal(r.getrDeal())
				.Build();
		return result;
	}
	private static Recharge cloneRecharge(Recharge r) {
		Recharge result= new Recharge(r.gettId(), r.gettUId(), r.gettPayType(), r.gettTime());
		return result;
	}
	private static HouseType cloneHouseType(HouseType h) {
		HouseType result= new HouseType(h.gettId(), h.gettContext(), h.gettDescription());
		return result;
	}
	private static User cloneUser(User u) {
		User result= new  User(u.getuId(), u.getuName(), u.getuPassword(), u.getuPassword(), u.getuPhoneNumber(), u.getuEmail(),
				u.getuBirthday(), u.getuAge(), u.getuGender(), u.getuDescription(), u.getuLocation(), u.getuVerification(),
				u.getuMoney(), u.getuStatus(), u.getuType());
		return result;
	}
	private static House cloneHouse(House h) {
		House result= new House.Builder()
				.hId(h.gethId())
				.hOwnerId(h.gethOwnerId())
				.hPicture(h.gethPicture())
				.hAddress(h.gethAddress())
				.hType(h.gethType())
				.hSize(h.gethSize())
				.hDate(h.gethDate())
				.hEnergy(h.gethEnergy())
				.hEquipment(h.gethEquipment())
				.hPark(h.gethPark())
				.hDescription(h.gethDescription())
				.hVerification(h.gethVerification())
				.Build();
		return result;
	}
}
