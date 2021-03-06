package ie.ul.cs4227.Bass.Util;

public class FactoryProducer {

   public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("Converter")){
         return new ConverterFactory();
      } else if(choice.equalsIgnoreCase("Validator")){
         return new VaildatorFactory();
      } else if(choice.equalsIgnoreCase("Tools")) {
    	 return new ToolFactory();
      }
      return null;
   }

}
