package ie.ul.cs4227.Bass.Util;

public class ConverterFactory extends AbstractFactory {
	@Override
	public Converter getConverter(String ConverterType){
	      if(ConverterType == null){
	         return null;
	      }        
	      if(ConverterType.equalsIgnoreCase("DATE")){
	         return new DateConverter();
	      } else if(ConverterType.equalsIgnoreCase("TIME")){
	         return new Timeconverter();
	      }
	      return null;
	   }
	public Validator getValidator(String input) {
		return null;
	}
	@Override
	public Tools getTools(String input) {
		return null;
	}
}
