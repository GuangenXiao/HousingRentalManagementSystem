package ie.ul.cs4227.Bass.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ie.ul.cs4227.Bass.Entity.Recharge;
import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Service.ITopUpService;
import ie.ul.cs4227.Bass.Service.TopUpService;

@RestController
public class TopUpController {

	@Resource
	ITopUpService tus= new TopUpService();
	
	@GetMapping("/testTopUpAdmin")
	public String testTopUp(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {

		User u = new User.Builder().uId(1).uType("admin").uMoney((float) 0.0).Build();
		return ""+tus.TopUp(u, 10, "card");
	}
	@GetMapping("/testTopUpOwner")
	public String testTopUpOwner(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {

		User u = new User.Builder().uId(2).uType("owner").uMoney((float) 0.0).Build();
		return ""+tus.TopUp(u, 10, "card");
	}
	
}
