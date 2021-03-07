package ie.ul.cs4227.Bass.Util;

public class ToolFactory extends AbstractFactory{

	@Override
	public Converter getConverter(String input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Validator getValidator(String input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tools getTools(String input) {
		 if(input == null){
	         return null;
	      }        
	      if(input.equalsIgnoreCase("Age")){
	         return new AgeTools();
	      }else if (input.equalsIgnoreCase("FileUpLoad")) {
	    	 return new FileTools();
	      }
		return null;
	}

}
