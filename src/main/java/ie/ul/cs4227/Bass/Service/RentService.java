package ie.ul.cs4227.Bass.Service;


import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import ie.ul.cs4227.Bass.Dao.RentalDao;
import ie.ul.cs4227.Bass.Entity.Rental;




public class RentService implements IRentService {
	@Autowired
	@Resource
	RentalDao ren;
	
	public RentService() 
	{
		
	}
	@Override
	public Boolean insertRent(Rental R) {
		// TODO Auto-generated method stub
		Boolean result=null;
		 try {
				result= ren.insertRental(R);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	@Override
	public ArrayList<Rental> findReantals(Integer Owner) {
		// TODO Auto-generated method stub
		

		 ArrayList<Rental> list=null;
		 try {
			list= ren.findrentals(Owner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
	}
	@Override
	public Boolean updateRental(Integer RentalID) {
		// TODO Auto-generated method stub
		Boolean result=null;
		 try {
				result= ren.updateRental(RentalID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	@Override
	public Boolean deteleRental(Integer RentalID) {
		// TODO Auto-generated method stub
		Boolean result=null;
		 try {
				result= ren.deteleRental(RentalID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
}
