package ie.ul.cs4227.Bass.Service.Proxy;

import java.lang.reflect.Method;

public class ApplyBoxRejectProxy implements iProxy{
	
	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("ApplyBoxRejectInterceptor before...");
		return true;
	}
	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("ApplyBoxRejectInterceptor around...");
	}
	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("ApplyBoxRejectInterceptor after...");
	}
}
