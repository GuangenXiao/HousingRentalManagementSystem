package ie.ul.cs4227.Bass.Service.Proxy;

import java.lang.reflect.Method;

public class SearchUserProxy implements iProxy{
	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("SearchUserInterceptor before...");
		return true;
	}
	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("SearchUserInterceptor around...");
	}
	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("SearchUserInterceptor after...");
	}
}
