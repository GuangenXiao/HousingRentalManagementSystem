package ie.ul.cs4227.Bass.Util;

import java.util.Calendar;
import java.util.Date;

public class AgeTools implements Tools{

	@Override
	public int launch(Date birthDay) throws Exception {
	        Calendar cal = Calendar.getInstance(); 
	        if (cal.before(birthDay)) { 
	            throw new IllegalArgumentException(
	                    "The birthDay is before Now.It's unbelievable!");
	        }
	        int yearNow = cal.get(Calendar.YEAR);  
	        int monthNow = cal.get(Calendar.MONTH);  
	        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); 
	        cal.setTime(birthDay); 
	        int yearBirth = cal.get(Calendar.YEAR);
	        int monthBirth = cal.get(Calendar.MONTH);
	        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
	        int age = yearNow - yearBirth;   
	            if (monthNow <= monthBirth) {
	            if (monthNow == monthBirth) {
	                if (dayOfMonthNow < dayOfMonthBirth) age--;
	            }else{
	                age--;
	       } } 
	            return age; 
	}

	@Override
	public void uploadfile(byte[] file, String filePath, String fileName) throws Exception {
		// TODO Auto-generated method stub
	}  

}
