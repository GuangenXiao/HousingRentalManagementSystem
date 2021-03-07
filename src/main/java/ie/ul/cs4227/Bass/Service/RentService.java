package ie.ul.cs4227.Bass.Service;


import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import ie.ul.cs4227.Bass.Dao.RentalDao;
import ie.ul.cs4227.Bass.Entity.Rental;
import ie.ul.cs4227.Bass.Service.RentalCommand.*;




public class RentService implements IRentService {
	@Autowired
	@Resource
	RentalDao ren;
	
	
	public RentService() 
	{
		
	}
	@Override
	public Boolean insertRent(Rental R) {		 
		Command com = new CommandCreate(ren);
		Invoker invoker = new Invoker(com);
		return invoker.call(R);
	}
	@Override
	public Boolean dealRental(Integer RentalID) {
		Command com = new CommandDeal(ren);
		Invoker invoker = new Invoker(com);
		return invoker.call(new Rental.Builder().rId(RentalID).Build());
	}
	@Override
	public Boolean deteleRental(Integer RentalID) {
		Command com = new CommandDelete(ren);
		Invoker invoker = new Invoker(com);
		return invoker.call(new Rental.Builder().rId(RentalID).Build());
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
}
