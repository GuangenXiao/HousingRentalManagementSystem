package ie.ul.cs4227.Bass.Filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ie.ul.cs4227.Bass.Util.*;
/**
 * Servlet Filter implementation class AutoLoginFilter
 */
@WebFilter(urlPatterns="/login.jsp",dispatcherTypes={DispatcherType.REQUEST, DispatcherType.FORWARD})
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html;charset=utf-8");
		String usermsg=null;
		HttpServletRequest req = (HttpServletRequest)request;
		Cookie[] cookies =  req.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++)
		{
			if(cookies[i].getName().equals("autologin"))
				{
				usermsg=cookies[i].getValue();
				break;
				}
		}
		// pass the request along the filter chain
		
		if(usermsg!=null)
		{
			String[] parts= usermsg.split("-");
			String userId = parts[0];
			String password = parts[1];
			if(userId.length()<=0||password.length()<=0)
			{
				chain.doFilter(req, response);
				return;
			}
			if(!Validator.isNumber(userId))
			{
				chain.doFilter(req, response);
				return;
			}
			req.setAttribute("userid", userId);
			req.setAttribute("password", password);
			chain.doFilter(req, response);
		}
		else
		chain.doFilter(req, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
