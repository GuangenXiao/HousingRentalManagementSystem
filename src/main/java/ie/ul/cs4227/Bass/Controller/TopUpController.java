package ie.ul.cs4227.Bass.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ie.ul.cs4227.Bass.Entity.Recharge;
import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Service.ITopUpService;
import ie.ul.cs4227.Bass.Service.IVisitorService;
import ie.ul.cs4227.Bass.Service.TopUpService;
import ie.ul.cs4227.Bass.Util.Validator;
import ie.ul.cs4227.Service.Proxy.*;

@RestController
public class TopUpController {

	@Resource
	ITopUpService tus = new TopUpService();

	@GetMapping("/testTopUpAdmin")
	public String testTopUp(HttpServletRequest request, HttpServletResponse response) throws IOException {

		User u = new User.Builder().uId(1).uType("admin").uMoney((float) 0.0).Build();
		return "" + tus.TopUp(u, (float) 10.0, "card");
	}

	@GetMapping("/testTopUpOwner")
	public String testTopUpOwner(HttpServletRequest request, HttpServletResponse response) throws IOException {

		User u = new User.Builder().uId(2).uType("owner").uMoney((float) 0.0).Build();
		return "" + tus.TopUp(u, (float) 10, "card");
	}

	@GetMapping("/TopUp")
	public ModelAndView TopUpPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = (User) request.getSession().getAttribute("u");
		ModelAndView mv = new ModelAndView();
		if (user == null) {
			mv.setViewName("index");
			mv.addObject("msg", "Please login");
			return mv;
		}
		mv.setViewName("TopUp");
		return mv;
	}

	@PostMapping("/TopUp")
	public ModelAndView TopUp(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "Amount", required = true) String Amount,
			@RequestParam(value = "PaymentType", required = true) String PaymentType) throws IOException {
		User user = (User) request.getSession().getAttribute("u");
		ModelAndView mv = new ModelAndView();
		if (user == null) {
			mv.setViewName("index");
			mv.addObject("msg", "Please login");
			return mv;
		}
		Boolean result = false;

		try {
			Float amountNum = Float.parseFloat(Amount);
			
			ITopUpService tusproxy = (ITopUpService) InterceptorJdkProxy.bind(tus,new LogProxy());
			result = tusproxy.TopUp(user, amountNum, PaymentType);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (result == true) {
			mv.addObject("msg", "TopUp Successfully");
			
		}else {
			mv.addObject("msg", "TopUp Failed");
		}

		mv.setViewName("index");
		return mv;
	}

}
