package ie.ul.cs4227.Bass.Service.Interceptor;

import java.util.ArrayList;

public class Dispatcher {
	 private ArrayList<Interceptor> interceptors;

	    Dispatcher(){
	        interceptors = new ArrayList<>();
	    }

	    public void register(Interceptor interceptor){
	        interceptors.add(interceptor);
	    }

	    public void unRegister(Interceptor interceptor){
	        interceptors.remove(interceptor);
	    }

	    public void setInterceptors(ArrayList<Interceptor> interceptors){
	        this.interceptors = interceptors;
	    }

	    void dispatchInterceptor(Context context){
	            interceptors.forEach(i -> i.execute(context));
	    }
}
