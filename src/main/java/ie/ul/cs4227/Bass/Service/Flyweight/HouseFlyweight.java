package ie.ul.cs4227.Bass.Service.Flyweight;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import ie.ul.cs4227.Bass.Dao.HouseDao;
import ie.ul.cs4227.Bass.Entity.House;

public class HouseFlyweight {
	private static HashMap<String, ArrayList<House>> HouseMap = new HashMap<String, ArrayList<House>>();
	private static Long  lastUpdate=null;
	public static ArrayList<House> getList(HouseDao hd,String info,Integer type) {
		if(lastUpdate==null)lastUpdate=System.currentTimeMillis();
		Long current = System.currentTimeMillis();
		ArrayList<House>  result=null;
		if((current-lastUpdate)<=300000) {
			result = HouseMap.get(info+"$"+type);
		}else {
			HouseMap  = new HashMap<String, ArrayList<House>>();
		}
		
		if(result==null) {
			 try {
					result= hd.findHouses(info, type);
					HouseMap.put(info+"$"+type, result);
					System.out.println("access database!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return  result;
	}
	
	
}
