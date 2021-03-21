package ie.ul.cs4227.Bass.Service.Flyweight;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import ie.ul.cs4227.Bass.Entity.House;

public class HouseFlyweight {
	private static final HashMap<String, ArrayList<House>> HouseMap = new HashMap<String, ArrayList<House>>();
	private static long  lastUpdate;
	public static ArrayList<House> getList(String info,String type) {
		lastUpdate = System.currentTimeMillis();
		ArrayList<House>  result = HouseMap.get(info+"_"+type);
		
		
		return  null;
	}
	
	
}
