package ie.ul.cs4227.Bass.Service.PlugableAdapter;

import javax.servlet.http.HttpServletRequest;

import ie.ul.cs4227.Bass.Entity.User;
public class Adaptee {
	User BuildUser(HttpServletRequest request) {
		User user=new User();
		return user;
	}
}
