package ie.ul.cs4227.Service.Proxy;

import java.lang.reflect.Method;

public class ModifyProxy implements iProxy{
	
	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("ModifyInterceptor before...");
		return true;
	}
	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("ModifyInterceptor around...");
	}
	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("ModifyInterceptor after...");
	}
}
