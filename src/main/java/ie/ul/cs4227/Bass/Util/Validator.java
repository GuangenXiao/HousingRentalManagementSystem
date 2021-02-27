package ie.ul.cs4227.Bass.Util;

import java.util.regex.Pattern;

public class Validator {
	public static boolean isNotNull(String str) {
		String str1 = str.trim();
		if (null != str1 && !("".equals(str1))) {
			return true;
		}
		return false;
	}
	public static boolean isNumber(String str) {
		String str1 = str.trim();
		Pattern pattern = Pattern.compile("[0-9]+");
		return pattern.matcher(str1).matches();
	}
	 public static boolean getGender(String choose) {
			if(choose=="1")
			{
				return true;
			}
			else
			{
				return false;
			}
		}
}
