package ie.ul.cs4227.Bass.Controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ie.ul.cs4227.Bass.Entity.Rental;
import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Service.*;



@RestController
public class RentalControllor {
///SearchRentalServlet
///RentServlet
	@Resource
	IRentService irs = new RentService();
	
	@GetMapping("/ApplyBox")
	public ModelAndView applyBox(HttpServletRequest request, 
			HttpServletResponse response) {
		User user = (User)request.getSession().getAttribute("u");
		ModelAndView mv= new ModelAndView();
		if(user==null) {
			mv.setViewName("index");
			mv.addObject("msg","Please login");
			return mv;
		}
		Integer ID=user.getuId();
		
		ArrayList<Rental> rentallist =irs.findReantals(ID); 
		mv.setViewName("ApplyBox");
		mv.addObject("rentallist",rentallist);
		return mv;
	}
	@GetMapping("/ApplyBoxReject")
	public ModelAndView ApplyBoxReject(HttpServletRequest request, 
			HttpServletResponse response,@RequestParam(value="rentalId",required = true)String rentalId) {
		User user = (User)request.getSession().getAttribute("u");
		ModelAndView mv= new ModelAndView();
		if(user==null) {
			mv.setViewName("index");
			mv.addObject("msg","Please login");
			return mv;
		}
		Boolean result=irs.deteleRental(Integer.parseInt(rentalId));
		Integer ID=user.getuId();
		ArrayList<Rental> rentallist =irs.findReantals(ID); 
		mv.setViewName("ApplyBox");
		mv.addObject("rentallist",rentallist);
		mv.addObject("result",result);
		return mv;
	}
	@GetMapping("/ApplyBoxAccept")
	public ModelAndView ApplyBoxAccept(HttpServletRequest request, 
			HttpServletResponse response,@RequestParam(value="rentalId",required = true)String rentalId) {
		User user = (User)request.getSession().getAttribute("u");
		ModelAndView mv= new ModelAndView();
		if(user==null) {
			mv.setViewName("index");
			mv.addObject("msg","Please login");
			return mv;
		}
		Boolean result=irs.dealRental(Integer.parseInt(rentalId));
		Integer ID=user.getuId();
		ArrayList<Rental> rentallist =irs.findReantals(ID); 
		mv.setViewName("ApplyBox");
		mv.addObject("rentallist",rentallist);
		mv.addObject("result",result);
		return mv;
	}
}
