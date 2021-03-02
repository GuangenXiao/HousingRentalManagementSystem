package ie.ul.cs4227.Bass.Controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Util.*;
import ie.ul.cs4227.Bass.Service.IUserService;
import ie.ul.cs4227.Bass.Service.UserService;
import ie.ul.cs4227.Bass.Util.Validator;

@RestController
public class UserControllor {
///LoginServlet
	// HttpServletRequest request, HttpServletResponse response
	@Resource
	IUserService ius = new UserService();

	@PostMapping("/LoginServlet")
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html;charset=utf-8");
		String userId = request.getParameter("userName");
		String password = request.getParameter("passWord");
		StringBuffer msg = new StringBuffer();
		if (userId == null || password == null) {
			msg.append("user Id or password can't be empty");
			request.setAttribute("msg", msg.toString());
			toLogin(request, response);
			return null;
		}
		if (userId.length() <= 0 || password.length() <= 0) {
			msg.append("user Id or password can't be empty");
			request.setAttribute("msg", msg.toString());
			toLogin(request, response);
			return null;
		}
		if (!Validator.isNumber(userId)) {
			msg.append("user Id should be number");
			request.setAttribute("msg", msg.toString());
			toLogin(request, response);
			return null;
		}
		User u = new User.Builder().uId(Integer.parseInt(userId)).uPassword(password).Build();
		User uResult = ius.UserLogin(u);
		System.out.println(uResult);
		if (uResult == null) {
			msg.append("No Suitable User");
			System.out.println("No Suitable User");
			request.setAttribute("msg", msg.toString());
			toLogin(request, response);
			return null;

		} else {

			if (!u.getuPassword().equals(uResult.getuPassword())) {
				msg.append("Incorrect password");
				System.out.println("Incorrect password");
				request.setAttribute("msg", msg.toString());
				toLogin(request, response);
				return null;
			}
			if (uResult.getuStatus() == false) {
				msg.append("Baned");
				System.out.println("banded");
				request.setAttribute("msg", msg.toString());
				toLogin(request, response);
				return null;
			}
			msg.append(":" + uResult.getuName());
			String time = request.getParameter("autologin");
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", uResult);
			if (time != null) {
				Cookie cookie = new Cookie("autologin", uResult.getuId() + "-" + uResult.getuPassword());
				cookie.setMaxAge(Integer.parseInt(time));
				cookie.setPath("/HRMS");
				response.addCookie(cookie);
			}
			System.out.println("login Successfully");
			request.setAttribute("msg", msg.toString());
			toIndex(request, response);
		}

		return null;

	}

	protected void toLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void toIndex(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
///LogoutServlet

///RegisterServlet

///SearchUserServlet

}
