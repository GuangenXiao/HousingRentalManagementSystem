package ie.ul.cs4227.Bass.Service.PlugableAdapter;

import javax.servlet.http.HttpServletRequest;

import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Entity.Visitor;

public class Adapter  {
	
	private  Adaptee adaptee;
	
	public Adapter(Adaptee adaptee) {
		this.adaptee=adaptee;
	}
    public Visitor doOtherThingWithClient(Client client)
    {

	return client.doTheThing(this::BulidVisitor);
    }
    
	public Visitor BulidVisitor(HttpServletRequest request) {
		
		Visitor VisitorAccont=new Visitor();
		String Ip= clientIp(request);
		VisitorAccont.setvIP(Ip);
		VisitorAccont.setvUser(adaptee.BuildUser());
		return VisitorAccont;
	}
	public String clientIp(HttpServletRequest request) {  
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
