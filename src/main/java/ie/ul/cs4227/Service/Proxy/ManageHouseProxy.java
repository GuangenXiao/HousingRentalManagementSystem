package ie.ul.cs4227.Service.Proxy;

import java.lang.reflect.Method;

public class ManageHouseProxy implements iProxy{

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("ManageHouseInterceptor before...");
		return true;
	}
	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("ManageHouseInterceptor around...");
	}
	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("ManageHouseInterceptor after...");
	}
}
