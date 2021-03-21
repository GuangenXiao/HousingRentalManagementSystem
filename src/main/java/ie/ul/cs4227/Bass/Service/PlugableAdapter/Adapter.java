package ie.ul.cs4227.Bass.Service.PlugableAdapter;

import javax.servlet.http.HttpServletRequest;

import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Entity.Visitor;

public class Adapter extends Adaptee implements ITarget {
	@Override
	public Visitor BulidVisitor(HttpServletRequest request) {
		User Visitor=new User.Builder().uId(4).uName("Visitor").uType("user").Build();
		Visitor VisitorAccont=new Visitor();
		
		String Ip= clientIp(request);
		VisitorAccont.setvIP(Ip);
		VisitorAccont.setvUser(Visitor);
		return VisitorAccont;
	}
	public static String clientIp(HttpServletRequest request) {  
	    String ip = request.getHeader("x-forwarded-for");  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("Proxy-Client-IP");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getRemoteAddr();  
	    }  
	    return ip;  
	}  
}
