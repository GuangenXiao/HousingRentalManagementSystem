package ie.ul.cs4227.Bass.Entity;
import java.util.Date;
public class User {
	private Integer  uId ;
	private String uName ;
	private String uPassword ;
	private String uIcon ;
	private String uPhoneNumber ;
	private String uEmail ;
	private Date uBirthday  ;
	private Integer uAge  ;
	private Boolean uGender ;
	private String uDescription ;
	private String uLocation ;
	private Date uVerification;
	private Float uMoney;
	private Boolean uStatus ;
	private String uType ;
	public User() {
		super();
	}

	
	
	public User(Integer uId, String uName, String uPassword, String uIcon, String uPhoneNumber, String uEmail,
			Date uBirthday, Integer uAge, Boolean uGender, String uDescription, String uLocation, Date uVerification,
			Float uMoney, Boolean uStatus, String uType) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uIcon = uIcon;
		this.uPhoneNumber = uPhoneNumber;
		this.uEmail = uEmail;
		this.uBirthday = uBirthday;
		this.uAge = uAge;
		this.uGender = uGender;
		this.uDescription = uDescription;
		this.uLocation = uLocation;
		this.uVerification = uVerification;
		this.uMoney = uMoney;
		this.uStatus = uStatus;
		this.uType = uType;
	}



	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuIcon() {
		return uIcon;
	}

	public void setuIcon(String uIcon) {
		this.uIcon = uIcon;
	}

	public String getuPhoneNumber() {
		return uPhoneNumber;
	}

	public void setuPhoneNumber(String uPhoneNumber) {
		this.uPhoneNumber = uPhoneNumber;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public Date getuBirthday() {
		return uBirthday;
	}

	public void setuBirthday(Date uBirthday) {
		this.uBirthday = uBirthday;
	}

	public Integer getuAge() {
		return uAge;
	}

	public void setuAge(Integer uAge) {
		this.uAge = uAge;
	}

	public Boolean getuGender() {
		return uGender;
	}

	public void setuGender(Boolean uGender) {
		this.uGender = uGender;
	}

	public String getuDescription() {
		return uDescription;
	}

	public void setuDescription(String uDescription) {
		this.uDescription = uDescription;
	}

	public String getuLocation() {
		return uLocation;
	}

	public void setuLocation(String uLocation) {
		this.uLocation = uLocation;
	}

	public Date getuVerification() {
		return uVerification;
	}

	public void setuVerification(Date uVerification) {
		this.uVerification = uVerification;
	}

	public Float getuMoney() {
		return uMoney;
	}

	public void setuMoney(Float uMoney) {
		this.uMoney = uMoney;
	}

	public Boolean getuStatus() {
		return uStatus;
	}

	public void setuStatus(Boolean uStatus) {
		this.uStatus = uStatus;
	}

	public String getuType() {
		return uType;
	}

	public void setuType(String uType) {
		this.uType = uType;
	}

	public static class Builder
	{
		private Integer  uId=null ;
		private String uName =null;
		private String uPassword=null ;
		private String uIcon =null;
		private String uPhoneNumber =null;
		private String uEmail =null;
		private Date uBirthday =null ;
		private Integer uAge =null ;
		private Boolean uGender =null;
		private String uDescription =null;
		private String uLocation =null;
		private Date uVerification=null;
		private Float uMoney=null;
		private Boolean uStatus =null;
		private String uType=null ;
		public Builder()
		{
			
		}
		
		public Builder uVerification(Date uVerification)
		{
			this.uVerification  =uVerification ;
			return this;
		}
		
		public Builder uType(String  uType)
		{
			this.uType =uType;
			return this;
		}
		public Builder uDescription(String  uDescription)
		{
			this.uDescription =uDescription;
			return this;
		}
		
		public Builder uLocation(String  uLocation)
		{
			this.uLocation = uLocation;
			return this;
		}
		
		public Builder uGender (Boolean uGender )
		{
			this.uGender  =uGender ;
			return this;
		}
		public Builder uAge(Integer uAge)
		{
			this.uAge = uAge;
			return this;
		}
		
		public Builder uId(Integer uId)
		{
			this.uId = uId;
			return this;
		}
		public Builder uName(String  uName)
		{
			this.uName = uName;
			return this;
		}
		public Builder uPassword (String uPassword )
		{
			this.uPassword  = uPassword ;
			return this;
		}
		public Builder  uBirthday(Date  uBirthday)
		{
			this. uBirthday =  uBirthday;
			return this;
		}
		public Builder uIcon(String uIcon)
		{
			this.uIcon = uIcon;
			return this;
		}
		public Builder uMoney(Float uMoney)
		{
			this.uMoney = uMoney;
			return this;
		}
		public Builder uEmail(String uEmail)
		{
			this.uEmail = uEmail;
			return this;
		}
		public Builder uPhoneNumber(String uPhoneNumber)
		{
			this.uPhoneNumber = uPhoneNumber;
			return this;
		}
		public Builder uStatus(Boolean uStatus)
		{
			this.uStatus =uStatus;
			return this;
		}
		public User Build()
		{
			return new User(uId, uName, uPassword, uIcon, uPhoneNumber, uEmail,
				uBirthday,  uAge,  uGender, uDescription,  uLocation, uVerification,
					 uMoney,  uStatus,uType);
		}
	}
	
}
