package ie.ul.cs4227.Bass.Service.Interceptor;

import java.util.Date;

import ie.ul.cs4227.Bass.Entity.Rental;

public class RentContext extends Context {
	 private  Integer rId;
	 private Integer rHId;
	 private Integer rUId;
	 private Integer rPrice;
	 private Date rStart;
	 private Date rEnd;
	 private Date rDeal;
	 private String filepath;
		public RentContext(Rental r,String filepath) {
			super();
			this.rId = r.getrId();
			this.rHId = r.getrHId();
			this.rUId = r.getrUId();
			this.rPrice = r.getrPrice();
			this.rStart = r.getrStart();
			this.rEnd = r.getrEnd();
			this.rDeal = r.getrDeal();
			this.filepath = filepath;
		}
	@Override
	 public String toString() {
		String nextLine=System.getProperty("line.separator");
		 return "User:"+rUId+" want to rent House:"+rHId+" from Date:"+rStart +" to Date:"+rEnd+nextLine;
	 }
	 
}
