package ie.ul.cs4227.Bass.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ie.ul.cs4227.Bass.Entity.User;



/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter(urlPatterns="/view.jsp")

public class SecurityFilterForView implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilterForView() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession httpSession =req.getSession();
		User u =(User) httpSession.getAttribute("user");
		if(u==null)
		{
		response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("/SecurityServlet").forward(req, response);
		return ;
		
		}
		chain.doFilter(request, response);


	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
