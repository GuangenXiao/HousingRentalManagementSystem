package ie.ul.cs4227.Bass.Util;

import java.text.ParseException;

public class GenderValidator implements Validator{
	@Override
	public boolean verifi(String str) throws Exception {
		if(str=="1")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
