 package ie.ul.cs4227.Bass.Service.OriginalInterceptor;

import java.util.ArrayList;

public class Application {

	public static  FrameWork  createFrameWork(){

	        FrameWork framework = new FrameWork();
	        ArrayList<Dispatcher> list = new ArrayList<Dispatcher>();    
	        Dispatcher rentDispatcher = new Dispatcher();
	        Interceptor logInterceptor = new LogInterceptor();
	        rentDispatcher.register(logInterceptor);
	        list.add(rentDispatcher);
	        framework.setDispatchers( list );
	        return framework;

	}
}
