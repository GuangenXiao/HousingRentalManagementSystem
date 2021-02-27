package ie.ul.cs4227.Bass.Util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public interface Converter {
	public abstract Date convertString(String input) throws ParseException;
	public abstract int getAge(Date birthDay) throws Exception;
	
	
	
	
}
