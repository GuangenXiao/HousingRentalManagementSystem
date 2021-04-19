package ie.ul.cs4227.Bass.Controller;

import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Entity.Visitor;
import ie.ul.cs4227.Bass.Service.IUserService;
import ie.ul.cs4227.Bass.Service.IVisitorService;
import ie.ul.cs4227.Bass.Service.UserService;
import ie.ul.cs4227.Bass.Service.VisitorService;
import ie.ul.cs4227.Bass.Service.PlugableAdapter.Adaptee;
import ie.ul.cs4227.Bass.Service.PlugableAdapter.Adapter;
import ie.ul.cs4227.Bass.Service.PlugableAdapter.Client;
import ie.ul.cs4227.Bass.Service.PlugableAdapter.ITarget;
import ie.ul.cs4227.Bass.Service.Proxy.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class VisitorControllor {
	
	@Resource
	IVisitorService ivs = new VisitorService();
	
	@GetMapping("/index")
	public  ModelAndView  indexPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	
	@GetMapping("/VisitorModel")
	public ModelAndView BuildVisitor(HttpServletRequest request, HttpServletResponse response) {
		
		StringBuffer msg = new StringBuffer();
		ModelAndView mv = new ModelAndView();
		
		Visitor newVisitor=null;
		Adapter adapter = new Adapter(new Adaptee());
		
		Client client=new Client() {
			@Override
			public Visitor doTheThing(ITarget target) {
				// TODO Auto-generated method stub
				return target.generatVisitorWithRequest(request);
			}
		};
	    newVisitor=adapter.doOtherThingWithClient(client);
	    
	    User VisitorUser=null;
	    VisitorUser=newVisitor.getvUser();
	    
	    HttpSession httpSession = request.getSession();
		httpSession.setAttribute("u", VisitorUser);
		
		IVisitorService ivsproxy =  (IVisitorService) InterceptorJdkProxy.bind(ivs,new LogProxy());
		Integer result=ivsproxy.insertVisitor(newVisitor);
		if(result!=null) {
			msg.append("Visitor mode has been turned on for you");
			mv.addObject("msg", msg.toString());
			mv.setViewName("index");
			return mv;
		}
		else {
			msg.append("Visitor mode fail");
			mv.addObject("msg", msg.toString());
			mv.setViewName("index");
			return mv;
		}
	}
}
