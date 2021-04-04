package ie.ul.cs4227.Bass.Service.Interceptor;

import java.lang.reflect.Method;

public class AcceptApplicationInterceptor implements iInterceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("AcceptApplicationInterceptor before...");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("AcceptApplicationInterceptor around...");
		
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("AcceptApplicationInterceptor after...");
		
	}

}
