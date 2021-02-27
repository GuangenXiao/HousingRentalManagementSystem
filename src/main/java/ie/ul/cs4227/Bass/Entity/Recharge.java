package ie.ul.cs4227.Bass.Entity;
import java.util.Date;



public class Recharge {
	
	private Integer tId ;
	private Integer tUId  ;
	private String tPayType ; 
	private Date tTime;
	
	
	
	
	
	public Recharge(Integer tId, Integer tUId, String tPayType, Date tTime) {
		super();
		this.tId = tId;
		this.tUId = tUId;
		this.tPayType = tPayType;
		this.tTime = tTime;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public Integer gettUId() {
		return tUId;
	}
	public void settUId(Integer tUId) {
		this.tUId = tUId;
	}
	public String gettPayType() {
		return tPayType;
	}
	public void settPayType(String tPayType) {
		this.tPayType = tPayType;
	}
	public Date gettTime() {
		return tTime;
	}
	public void settTime(Date tTime) {
		this.tTime = tTime;
	}
	
	
	public static class Builder{
		private Integer tId=null ;
		private Integer tUId =null ;
		private String tPayType =null; 
		private Date tTime=null;
		public Builder()
		{
			
		}
		public Builder tId(Integer tId)
		{
			this.tId =tId;
			return this;
		}
		public Builder tUId(Integer tUId)
		{
			this.tUId =tUId;
			return this;
		}
		public Builder tPayType(String tPayType)
		{
			this.tPayType =tPayType;
			return this;
		}
		public Builder tTime(Date tTime)
		{
			this.tTime =tTime;
			return this;
		}
		public Recharge Build()
		{
			return new Recharge( tId, tUId, tPayType, tTime);
		}
	}
	
	

}
