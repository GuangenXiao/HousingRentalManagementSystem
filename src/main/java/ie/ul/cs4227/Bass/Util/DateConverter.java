package ie.ul.cs4227.Bass.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter implements Converter {

	public DateConverter() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Date convertString(String input) throws ParseException {
		// TODO Auto-generated method stub
		DateFormat aFormater = new SimpleDateFormat("yyyy-MM-dd"); 
		Date dateValue = (Date)aFormater.parse(input);
		return dateValue;
	}

}
