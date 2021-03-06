package ie.ul.cs4227.Bass.Util;

import java.text.ParseException;

public class NullValidator implements Validator {
	public NullValidator() {
		// TODO Auto-generated constructor stub
	}
	public boolean verifi(String str) {
		String str1 = str.trim();
		if (null != str1 && !("".equals(str1))) {
			return false;
		}
		return true;
	}
}
