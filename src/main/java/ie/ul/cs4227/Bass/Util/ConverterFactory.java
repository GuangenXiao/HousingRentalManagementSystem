package ie.ul.cs4227.Bass.Util;

public class ConverterFactory {

	public ConverterFactory() {
		// TODO Auto-generated constructor stub
	}
	public Converter getConverter(String shapeType){
	      if(shapeType == null){
	         return null;
	      }        
	      if(shapeType.equalsIgnoreCase("DATE")){
	         return new DateConverter();
	      } else if(shapeType.equalsIgnoreCase("TIME")){
	         return new Timeconverter();
	      }
	      return null;
	   }
}
