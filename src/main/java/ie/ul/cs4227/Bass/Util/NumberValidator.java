package ie.ul.cs4227.Bass.Util;

import java.text.ParseException;
import java.util.regex.Pattern;

public class NumberValidator implements Validator {
	@Override
	public boolean verifi(String str) throws Exception {
		String str1 = str.trim();
		Pattern pattern = Pattern.compile("[0-9]+");
		return pattern.matcher(str1).matches();
	}
}
