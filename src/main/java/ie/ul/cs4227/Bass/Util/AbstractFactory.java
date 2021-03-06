package ie.ul.cs4227.Bass.Util;

import java.text.ParseException;
import java.util.Date;

public abstract class AbstractFactory {
   public abstract Converter getConverter(String input) throws Exception;
   public abstract Validator getValidator(String input) throws Exception;
   public abstract Tools     getTools(String input)throws Exception;
}

