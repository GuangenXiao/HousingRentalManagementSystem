package ie.ul.cs4227.Bass.Service.Interceptor;

import java.lang.reflect.Method;

public class VisitorModelInterceptor implements iInterceptor{
	
	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("VisitorModelInterceptor before...");
		return true;
	}
	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("VisitorModelInterceptor around...");
	}
	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("VisitorModelInterceptor after...");
	}
}
