package ie.ul.cs4227.Service.Proxy;

import java.lang.reflect.Method;

public class AcceptApplicationProxy implements iProxy {

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
