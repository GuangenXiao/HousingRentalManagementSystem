package ie.ul.cs4227.Bass.Controller;

import java.io.IOException;
import java.util.Date;

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
import org.springframework.web.multipart.MultipartFile;
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
	

	@GetMapping("/Logout")
	public ModelAndView Logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		request.getSession().removeAttribute("user");
		return mv;
	}
	
///Register
	@GetMapping("/Register")
	public ModelAndView userRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Register");
		String msg =null;
		  if(request.getAttribute("msg")!=null)
		  {
		  	msg=request.getAttribute("msg").toString();
		  }
		mv.addObject("msg",msg);
		return mv;
	}
    @PostMapping("/Register")
    public ModelAndView userRegisterPost( @RequestParam(value="userName",required = false) String userName,
    		   @RequestParam(value="newPicture",required = false) MultipartFile file,
    	       @RequestParam(value="userphonenumber",required = false) String userphonenumber,
    	       @RequestParam(value="userBirthday",required = false) String userBirthday,
    	       @RequestParam(value="userEmail",required = false) String userEmail,
    	       @RequestParam(value="userPassword",required = false) String userPassword,
    	       @RequestParam(value="userDescription",required = false) String userDescription,
    	       @RequestParam(value="userLocation",required = false) String userLocation,
    	       @RequestParam(value="Gender",required = false) String Gender,
    	       @RequestParam(value="userType",required = false) String userType,
    	       HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	            ModelAndView mv = new ModelAndView();
    				StringBuffer msg = new StringBuffer();
    				User user=new User();	
    				user.setuName(userName);
    				user.setuPhoneNumber(userphonenumber);	
    				user.setuPassword(userPassword);					
    				user.setuLocation(userLocation);					
    				user.setuDescription(userDescription);
    				
    				AbstractFactory ToolFactory = FactoryProducer.getFactory("Tools");
    			    Tools filetool= ToolFactory.getTools("FileUpLoad");
    				String fileName = file.getOriginalFilename();
    		        String filePath = request.getSession().getServletContext().getRealPath("/Recource/");
    		        try {
    		        	    filetool.uploadfile(file.getBytes(), filePath, fileName);
    		        } catch (Exception e) {
    		        } 
    				user.setuIcon(fileName);
    				AbstractFactory validatorFactory = FactoryProducer.getFactory("Validator");
    			    Validator GenderV = validatorFactory. getValidator("getGender");
    				Boolean GenderResult=GenderV.verifi(Gender);
    				user.setuGender(GenderResult);				
    				
    				user.setuEmail(userEmail);	
    				/* This method can be a new tool to the abstract factory*/
       				user.setuType(userType);
       				
       				AbstractFactory ConverterFactory = FactoryProducer.getFactory("Converter");
    			    Converter dateCon = ConverterFactory.getConverter("DATE");
    				Date userBirth=dateCon.convertString(userBirthday);
    				user.setuBirthday(userBirth);
    				
    				Integer age =0;
    				 try { 					  
    	    			    Tools AgeT=ToolFactory.getTools("Age");
    			            age = AgeT.launch(userBirth); 
    			            if(age<18) {
    			            	msg.append("your age is under 18!");
    			            	mv.addObject("msg", msg.toString());
    							mv.setViewName("Register");
    							return mv;
    			            }
    			            user.setuAge(age);
    			            
    			        } catch (Exception e) {
    			            e.printStackTrace();
    			        }
    				if(user.getuName()==null||user.getuPhoneNumber()==null||user.getuBirthday()==null||user.getuEmail()==null||user.getuPassword()==null||user.getuDescription()==null||user.getuLocation()==null||user.getuAge()==null) {
    					msg.append("The required information is incomplete!");
    					mv.addObject("msg", msg.toString());
						mv.setViewName("Register");
						return mv;
    				}
    				if(user.getuName().length()<8||user.getuName().length()>16) {
    					msg.append("User name with illegal length!");
    					mv.addObject("msg", msg.toString());
						mv.setViewName("Register");
						return mv;
    				}
    				Validator NumberV = validatorFactory. getValidator("isNumber");
    				if(!NumberV.verifi(user.getuPhoneNumber())) {
    					msg.append("phoneNumber must be a number!");
    					mv.addObject("msg", msg.toString());
						mv.setViewName("Register");
						return mv;
    				}
    				if(!user.getuEmail().matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"))
    				{
    					msg.append("Illegal email format!");
    					mv.addObject("msg", msg.toString());
						mv.setViewName("Register");
						return mv;
    				}
    				User result=ius.registerNewUser(user);
    				if(result!=null) {
    					msg.append("You have successfully created an account");
    					mv.addObject("msg", msg.toString());
						mv.setViewName("Register");
						
    					/*Cookie cookie = new Cookie("autologin",result.getuId()+"-"+result.getuPassword());
    				    
    					cookie.setMaxAge(24*60*60);
    					cookie.setPath("/HRsys");
    					response.addCookie(cookie);
    					response.sendRedirect("/HRsys/login.jsp?newUser="+true);*/
    					return mv;
    				}
    				else
    				{
    					msg.append("An error has occurred");
    					mv.addObject("msg", msg.toString());
						mv.setViewName("Register");
						return mv;
    				}
    			} 

///SearchUserServlet
}
