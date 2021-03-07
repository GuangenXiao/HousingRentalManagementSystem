package ie.ul.cs4227.Bass.Service.RentalCommand;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import ie.ul.cs4227.Bass.Dao.RentalDao;

public class Cilent {

	@Autowired
	@Resource
	RentalDao rd;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Command command = new CommandCreate(rd);
		//command.execute();

	}

}
