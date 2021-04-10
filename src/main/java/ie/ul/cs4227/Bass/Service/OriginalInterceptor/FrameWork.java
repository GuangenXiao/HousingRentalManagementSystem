package ie.ul.cs4227.Bass.Service.OriginalInterceptor;

import java.util.ArrayList;

import ie.ul.cs4227.Bass.Service.IRentService;

public class FrameWork {
	private static FrameWork instance = null;
	
	private IRentService irs;
	
	private ArrayList<Dispatcher> dispatchers;
	
    public static FrameWork getInstance(){
    	
    	if(instance==null) {
    		instance=Application.createFrameWork();
    	}
        return instance;
    }
    
    public void applyRentService(IRentService irs) {
    	this.irs = irs;
    }
    public void handleRequest(Context context){
        dispatchers.forEach(d -> d.dispatchInterceptor(context));
    }
    public void setDispatchers(ArrayList<Dispatcher> dispatchers){
        this.dispatchers = dispatchers;
    }

}
