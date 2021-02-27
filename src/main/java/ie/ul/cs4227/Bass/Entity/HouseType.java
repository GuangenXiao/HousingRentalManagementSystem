package ie.ul.cs4227.Bass.Entity;

import java.util.Date;

public class HouseType {
	private Integer tId;
	private String tContext ;
	private String tDescription ;
	public HouseType() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public HouseType(Integer tId, String tContext, String tDescription) {
		super();
		this.tId = tId;
		this.tContext = tContext;
		this.tDescription = tDescription;
	}



	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String gettContext() {
		return tContext;
	}
	public void settContext(String tContext) {
		this.tContext = tContext;
	}
	public String gettDescription() {
		return tDescription;
	}
	public void settDescription(String tDescription) {
		this.tDescription = tDescription;
	}
	
	
	
	public static class Builder{
		private Integer tId;
		private String tContext ;
		private String tDescription ;
		public Builder()
		{
			
		}
		public Builder tId(Integer tId)
		{
			this.tId =tId;
			return this;
		}
		public Builder tContext(String tContext)
		{
			this.tContext =tContext;
			return this;
		}
		public Builder tDescription(String tDescription)
		{
			this.tDescription =tDescription;
			return this;
		}

		public  HouseType Build()
		{
			return new HouseType( tId,  tContext,  tDescription) ;
		}
	}

}
