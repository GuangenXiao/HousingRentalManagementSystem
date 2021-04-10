package ie.ul.cs4227.Service.Proxy;

import java.lang.reflect.Method;

public class SendApplicationProxy implements iProxy{
	
	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("SendApplicationInterceptor before...");
		return true;
	}
	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("SendApplicationInterceptor around...");
	}
	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("SendApplicationInterceptor after...");
	}
}
