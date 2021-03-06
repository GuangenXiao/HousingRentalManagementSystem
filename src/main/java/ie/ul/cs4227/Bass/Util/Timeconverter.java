package ie.ul.cs4227.Bass.Util;
import java.util.*;
import java.text.*;
import javax.swing.JOptionPane;
import java.io.*;
public class Timeconverter implements Converter {
	

	public Date convertString(String aDate) throws ParseException
	{
		DateFormat aFormater = new SimpleDateFormat("dd/MM/yyyy/hh/mm"); 
		Date dateValue = (Date)aFormater.parse(aDate);
		return dateValue;
	}
}
