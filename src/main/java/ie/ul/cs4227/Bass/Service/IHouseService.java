package ie.ul.cs4227.Bass.Service;

import java.util.ArrayList;

import ie.ul.cs4227.Bass.Entity.House;
import ie.ul.cs4227.Bass.Entity.HouseType;



public interface IHouseService {
	public  abstract ArrayList<House> findHouses(String info,Integer Type);
	public  abstract ArrayList<HouseType> findHTypes();
	public  abstract Boolean insertHouse(House h);
	public  abstract House serachhouseById(String ID);
	public  abstract Boolean deleteHouse(Integer houseId);
}
