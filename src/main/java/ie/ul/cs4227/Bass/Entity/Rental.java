package ie.ul.cs4227.Bass.Entity;
import java.sql.Timestamp;
import java.util.Date;

public class Rental {

	 private  Integer rId;
	 private Integer rHId;
	 private Integer rUId;
	 private Integer rPrice;
	 private Date rStart;
	 private Date rEnd;
	 private Date rDeal;

	 
	 
	public Rental() {
		super();
	}

	public Rental(Integer rId, Integer rHId, Integer rUId, Integer rPrice, Date rStart, Date rEnd, Date rDeal) {
		super();
		this.rId = rId;
		this.rHId = rHId;
		this.rUId = rUId;
		this.rPrice = rPrice;
		this.rStart = rStart;
		this.rEnd = rEnd;
		this.rDeal = rDeal;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public Integer getrHId() {
		return rHId;
	}

	public void setrHId(Integer rHId) {
		this.rHId = rHId;
	}

	public Integer getrUId() {
		return rUId;
	}

	public void setrUId(Integer rUId) {
		this.rUId = rUId;
	}

	public Integer getrPrice() {
		return rPrice;
	}

	public void setrPrice(Integer rPrice) {
		this.rPrice = rPrice;
	}

	public Date getrStart() {
		return rStart;
	}

	public void setrStart(Date rStart) {
		this.rStart = rStart;
	}

	public Date getrEnd() {
		return rEnd;
	}

	public void setrEnd(Date rEnd) {
		this.rEnd = rEnd;
	}

	public Date getrDeal() {
		return rDeal;
	}

	public void setrDeal(Date rDeal) {
		this.rDeal = rDeal;
	}

	public static class Builder{
		 private  Integer rId=null;
		 private Integer rHId=null;
		 private Integer rUId=null;
		 private Integer rPrice=null;
		 private Date rStart=null;
		 private Date rEnd=null;
		 private Date rDeal=null;
		 
		public Builder()
		{
			
		}
		public Builder rId(Integer rId)
		{
			this.rId =rId;
			return this;
		}
		public Builder rHId(Integer rHId)
		{
			this.rHId =rHId;
			return this;
		}
		public Builder rUId(Integer rUId)
		{
			this.rUId =rUId;
			return this;
		}
		public Builder rPrice(Integer rPrice)
		{
			this.rPrice=rPrice;
			return this;
		}
		public Builder tTime(Date rStart)
		{
			this.rStart =rStart;
			return this;
		}
		public Builder rEnd(Date rEnd)
		{
			this.rEnd =rEnd;
			return this;
		}
		public Builder  rDeal(Date  rDeal)
		{
			this.rDeal = rDeal;
			return this;
		}
		public Rental Build()
		{
			return new Rental( rId,  rHId,  rUId,  rPrice,  rStart,  rEnd,  rDeal);
		}
	}
	
	
}
