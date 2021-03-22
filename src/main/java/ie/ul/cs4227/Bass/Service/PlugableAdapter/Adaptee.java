package ie.ul.cs4227.Bass.Service.PlugableAdapter;

import javax.servlet.http.HttpServletRequest;

import ie.ul.cs4227.Bass.Entity.User;
public class Adaptee {
	User BuildUser() {
		User user=new User.Builder().uId(4).uName("Visitor").uType("user").Build();
		return user;
	}
}
