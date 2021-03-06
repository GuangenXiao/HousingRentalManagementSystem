package ie.ul.cs4227.Bass.Util;

public class VaildatorFactory extends AbstractFactory{
	@Override
	public Converter getConverter(String ConverterType){
	      return null;
	   }
	public Validator getValidator(String ValidatorType) {
		 if(ValidatorType == null){
	         return null;
	      }        
	      if(ValidatorType.equalsIgnoreCase("isNull")){
	         return new NullValidator();
	      } else if(ValidatorType.equalsIgnoreCase("isNumber")){
	         return new NumberValidator();
	      } else if(ValidatorType.equalsIgnoreCase("getGender")) {
	    	 return new GenderValidator();
	      }
		return null;
	}
	@Override
	public Tools getTools(String input) {
		// TODO Auto-generated method stub
		return null;
	}
}
