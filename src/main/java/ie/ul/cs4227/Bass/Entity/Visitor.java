package ie.ul.cs4227.Bass.Entity;

import java.util.Date;

public class Visitor {

	private Integer vId;
	private Date vDate;
	private String vIP;
	private User vUser;
	
	
	public Visitor() {
		super();
	}

	public Visitor(Integer vId, Date vDate, String vIP, User vUser) {
		super();
		this.vId = vId;
		this.vDate = vDate;
		this.vIP = vIP;
		this.vUser = vUser;
	}
	
	public Integer getvId() {
		return vId;
	}
	public void setvId(Integer vId) {
		this.vId = vId;
	}
	public Date getvDate() {
		return vDate;
	}
	public void setvDate(Date vDate) {
		this.vDate = vDate;
	}
	public String getvIP() {
		return vIP;
	}
	public void setvIP(String vIP) {
		this.vIP = vIP;
	}
	public User getvUser() {
		return vUser;
	}
	public void setvUser(User vUser) {
		this.vUser = vUser;
	}
	
	
	
	
}
