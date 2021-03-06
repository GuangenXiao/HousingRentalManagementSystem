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
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/Login")
	public ModelAndView userLogin(HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value="userName",required = true) String userId,
			@RequestParam(value="passWord",required = true) String password,
			@RequestParam(value="autologin",required = true)String time
			) throws Exception {
		System.out.println("1111");
	    ModelAndView mv = new ModelAndView();
		StringBuffer msg = new StringBuffer();
		if (userId == null || password == null) {
			msg.append("user Id or password can't be empty");
			mv.setViewName("login");
			mv.addObject("msg", msg.toString());
			return null;
		}
		if (userId.length() <= 0 || password.length() <= 0) {
			msg.append("user Id or password can't be empty");
			mv.setViewName("login");
			mv.addObject("msg", msg.toString());
			return null;
		}
		AbstractFactory af = FactoryProducer.getFactory("Validator");
		Validator isNumber = af.getValidator("isNumber");
		if (!isNumber.verifi(userId)) {
			msg.append("user Id should be number");
			mv.setViewName("login");
			mv.addObject("msg", msg.toString());
			return null;
		}
		User u = new User.Builder().uId(Integer.parseInt(userId)).uPassword(password).Build();
		User uResult = ius.UserLogin(u);
		System.out.println(uResult);
		if (uResult == null) {
			msg.append("No Suitable User");
			System.out.println("No Suitable User");
			mv.setViewName("login");
			mv.addObject("msg", msg.toString());
			return null;

		} else {

			if (!u.getuPassword().equals(uResult.getuPassword())) {
				msg.append("Incorrect password");
				System.out.println("Incorrect password");
				mv.setViewName("login");
				mv.addObject("msg", msg.toString());
				return null;
			}
			if (uResult.getuStatus() == false) {
				msg.append("Baned");
				System.out.println("banded");
				mv.setViewName("login");
				mv.addObject("msg", msg.toString());
				return null;
			}
			msg.append(":" + uResult.getuName());
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("u", uResult);
			if (time != null) {
				Cookie cookie = new Cookie("autologin", uResult.getuId() + "-" + uResult.getuPassword());
				cookie.setMaxAge(Integer.parseInt(time));
				cookie.setPath("/HRMS");
				response.addCookie(cookie);
			}
			System.out.println("login Successfully");
			request.setAttribute("msg", msg.toString());
			mv.setViewName("index");
			mv.addObject("msg", msg.toString());
			return mv;
		}

	}
	@GetMapping("/Login")
	public ModelAndView LoginPage(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		/*
		 * String msg="You have successfully created an account"; String
		 * s="<script   language=javascript>alert('Resgister Successfully, Your Id is "
		 * +1+" ');</script>"; response.getWriter().write(s);
		 */
		return mv;
	}
///LogoutServlet

///RegisterServlet

///SearchUserServlet

}
