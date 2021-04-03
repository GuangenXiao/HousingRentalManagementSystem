package ie.ul.cs4227.Bass.Service.Interceptor;


import java.lang.reflect.Method;

public interface iInterceptor {
 
    boolean before(Object proxy, Object target, Method method,Object[] args);
 
    void around(Object proxy,Object target,Method method,Object[] args);
 
    void after(Object proxy,Object target,Method method,Object[] args);
 
}