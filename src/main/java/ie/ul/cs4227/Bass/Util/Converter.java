package ie.ul.cs4227.Bass.Util;

import java.util.Date;
import java.text.ParseException;

public interface Converter {
	public abstract Date convertString(String input) throws ParseException;
}
