package ie.ul.cs4227.Bass.Service.RentalCommand;

import ie.ul.cs4227.Bass.Dao.RentalDao;
import ie.ul.cs4227.Bass.Entity.Rental;

public class Invoker {

	private Command requirer;
	public Invoker(Command requirer) {
		this.requirer = requirer;
	}
    public void call(Rental r){
        //请求者调用命令对象执行命令的那个execute方法
        requirer.execute(r);
    }
}
