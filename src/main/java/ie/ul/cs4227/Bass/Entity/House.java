package ie.ul.cs4227.Bass.Entity;
import java.util.Date;
public class House {
	
	
	private Integer hId ;
	private Integer hOwnerId ;
	private String hPicture; 
	private String hAddress; 
	private Integer hType; 
	private Integer hSize  ;
	private Date hDate;
	private String hEnergy ;
	private String hEquipment;
	private Integer hPark;
	private String hDescription;
	private Date hVerification;
	
	public House() {
		super();
	}
	
	public House(Integer hId, Integer hOwnerId, String hPicture, String hAddress, Integer hType, Integer hSize,
			Date hDate, String hEnergy, String hEquipment, Integer hPark, String hDescription, Date hVerification) {
		super();
		this.hId = hId;
		this.hOwnerId = hOwnerId;
		this.hPicture = hPicture;
		this.hAddress = hAddress;
		this.hType = hType;
		this.hSize = hSize;
		this.hDate = hDate;
		this.hEnergy = hEnergy;
		this.hEquipment = hEquipment;
		this.hPark = hPark;
		this.hDescription = hDescription;
		this.hVerification = hVerification;


	}

	public Integer gethId() {
		return hId;
	}

	public void sethId(Integer hId) {
		this.hId = hId;
	}

	public Integer gethOwnerId() {
		return hOwnerId;
	}

	public void sethOwnerId(Integer hOwnerId) {
		this.hOwnerId = hOwnerId;
	}

	public String gethPicture() {
		return hPicture;
	}

	public void sethPicture(String hPicture) {
		this.hPicture = hPicture;
	}

	public String gethAddress() {
		return hAddress;
	}

	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}

	public Integer gethType() {
		return hType;
	}

	public void sethType(Integer hType) {
		this.hType = hType;
	}

	public Integer gethSize() {
		return hSize;
	}

	public void sethSize(Integer hSize) {
		this.hSize = hSize;
	}

	public Date gethDate() {
		return hDate;
	}

	public void sethDate(Date hDate) {
		this.hDate = hDate;
	}

	public String gethEnergy() {
		return hEnergy;
	}

	public void sethEnergy(String hEnergy) {
		this.hEnergy = hEnergy;
	}

	public String gethEquipment() {
		return hEquipment;
	}

	public void sethEquipment(String hEquipment) {
		this.hEquipment = hEquipment;
	}

	public Integer gethPark() {
		return hPark;
	}

	public void sethPark(Integer hPark) {
		this.hPark = hPark;
	}

	public String gethDescription() {
		return hDescription;
	}

	public void sethDescription(String hDescription) {
		this.hDescription = hDescription;
	}

	public Date gethVerification() {
		return hVerification;
	}

	public void sethVerification(Date hVerification) {
		this.hVerification = hVerification;
	}

	public static class Builder
	{
		private Integer hId =null;
		private Integer hOwnerId=null ;
		private String hPicture=null; 
		private String hAddress=null; 
		private Integer hType=null; 
		private Integer hSize  =null;
		private Date hDate=null;
		private String hEnergy=null ;
		private String hEquipment=null;
		private Integer hPark=null;
		private String hDescription=null;
		private Date hVerification=null;
		public Builder()
		{
			
		}
		
		public Builder hId(Integer hId)
		{
			this.hId  =hId ;
			return this;
		}
		public Builder hOwnerId(Integer hOwnerId)
		{
			this.hOwnerId  =hOwnerId ;
			return this;
		}
		public Builder hPicture(String hPicture)
		{
			this.hPicture =hPicture;
			return this;
		}
		public Builder hAddress(String hAddress)
		{
			this.hAddress =hAddress;
			return this;
		}
		
		public Builder  hType(Integer hType)
		{
			this.hType  = hType ;
			return this;
		}
		public Builder hSize(Integer hSize)
		{
			this.hSize  =hSize ;
			return this;
		}
		public Builder hDate(Date hDate)
		{
			this.hDate  =hDate ;
			return this;
		}
		public Builder hEnergy(String hEnergy)
		{
			this.hEnergy =hEnergy;
			return this;
		}
		public Builder hEquipment(String hEquipment)
		{
			this.hEquipment =hEquipment;
			return this;
		}
		public Builder hPark(Integer hPark)
		{
			this.hPark =hPark;
			return this;
		}
		public Builder hDescription(String hDescription)
		{
			this.hDescription =hDescription;
			return this;
		}
		public Builder hVerification(Date hVerification)
		{
			this.hVerification =hVerification;
			return this;
		}
		public House Build()
		{
			return new House(hId, hOwnerId,  hPicture,  hAddress,  hType,  hSize,
					hDate, hEnergy,  hEquipment, hPark, hDescription, hVerification);
		}
	}
	

}
