package ie.ul.cs4227.Bass.Controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Service.IUserService;
import ie.ul.cs4227.Bass.Service.UserService;

@RestController
public class TestController {
	@Resource
	IUserService ius =new UserService();
	
	@GetMapping("/test")
	public String TestPage() {

		
		//ArrayList<User> u=ius.findUsers("1", "Administrator");
		User u =ius.UserLogin(new User.Builder().uId(1).Build());
		System.out.println( ""+u.getuName());
		
		return ""+u.getuName();

	}
	@GetMapping("/hello")
	public String hello() {
		return "hello String boot";
		// TODO Auto-generated constructor stub
	}
}
