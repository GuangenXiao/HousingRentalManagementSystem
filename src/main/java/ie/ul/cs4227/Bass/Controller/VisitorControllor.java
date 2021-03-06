package ie.ul.cs4227.Bass.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ie.ul.cs4227.Bass.Entity.User;

@RestController
public class VisitorControllor {
	@GetMapping("/index")
	public ModelAndView IndexPage() {
		//HttpSession httpSession = request.getSession();
		//User u =(User)httpSession.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		//mv.addObject("u",u);
		
		
		return mv;
		// TODO Auto-generated constructor stub
	}
}
