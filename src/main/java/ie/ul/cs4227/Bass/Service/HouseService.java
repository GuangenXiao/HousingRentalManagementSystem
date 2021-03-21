package ie.ul.cs4227.Bass.Service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.ul.cs4227.Bass.Dao.HouseDao;
import ie.ul.cs4227.Bass.Entity.House;
import ie.ul.cs4227.Bass.Entity.HouseType;
import ie.ul.cs4227.Bass.Service.Flyweight.HouseFlyweight;

@Service
public class HouseService implements IHouseService {
	@Autowired
	@Resource
	HouseDao hd;
	public HouseService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<House> findHouses(String info,Integer type) {
		// TODO Auto-generated method stub
		 ArrayList<House> list=HouseFlyweight.getList(hd, info, type);		 
		return list;
	}

	@Override
	public ArrayList<HouseType> findHTypes() {
		// TODO Auto-generated method stub
		 ArrayList<HouseType> list=null;
		 try {
			list= hd.findHTypes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
	}
	@Override
	public Boolean insertHouse(House h) {
		// TODO Auto-generated method stub
		
		 Boolean result=null;
		 try {
			result=hd.insertHouse(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public House serachhouseById(String ID) {
		// TODO Auto-generated method stub
		
		 House h = new House.Builder().hId(Integer.parseInt(ID)).Build();
		 House result=null;
		 try {
			
			result=hd.searchHouseByID(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean deleteHouse(Integer houseId) {
		// TODO Auto-generated method stub
		 Integer result=null;
		 try {
			result=hd.deleteHouse(houseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0?true:false;
	}

}
