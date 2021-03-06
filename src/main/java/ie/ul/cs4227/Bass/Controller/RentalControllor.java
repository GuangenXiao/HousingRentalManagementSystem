package ie.ul.cs4227.Bass.Controller;

import java.util.Date;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sun.el.parser.ParseException;

import ie.ul.cs4227.Bass.Entity.House;
import ie.ul.cs4227.Bass.Entity.Rental;
import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Service.*;
import ie.ul.cs4227.Bass.Service.Interceptor.FrameWork;
import ie.ul.cs4227.Bass.Service.Interceptor.RentContext;
import ie.ul.cs4227.Bass.Service.Proxy.*;
import ie.ul.cs4227.Bass.Util.AbstractFactory;
import ie.ul.cs4227.Bass.Util.Converter;
import ie.ul.cs4227.Bass.Util.FactoryProducer;
import ie.ul.cs4227.Bass.Util.Validator;


@RestController
public class RentalControllor {
///SearchRentalServlet
///RentServlet
	@Resource
	IRentService irs = new RentService();
	@Resource
	IHouseService ihs = new HouseService();
	
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
		IRentService ApplyBoxproxy =(IRentService) InterceptorJdkProxy.bind(irs,new ApplyBoxProxy());
		Integer ID=user.getuId();
		
		ArrayList<Rental> rentallist =ApplyBoxproxy.findReantals(ID); 
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
		IRentService ApplyBoxRejectproxy =(IRentService) InterceptorJdkProxy.bind(irs,new ApplyBoxRejectProxy());
		Boolean result=ApplyBoxRejectproxy.deteleRental(Integer.parseInt(rentalId));
		Integer ID=user.getuId();
		ArrayList<Rental> rentallist =ApplyBoxRejectproxy.findReantals(ID); 
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
		IRentService ApplyAccpetproxy =(IRentService) InterceptorJdkProxy.bind(irs,new AcceptApplicationProxy());
		Boolean result=ApplyAccpetproxy.dealRental(Integer.parseInt(rentalId));
		Integer ID=user.getuId();
		ArrayList<Rental> rentallist =ApplyAccpetproxy.findReantals(ID); 
		mv.setViewName("ApplyBox");
		mv.addObject("rentallist",rentallist);
		mv.addObject("result",result);
		return mv;
	}
	@GetMapping("/HouseRent")
	public ModelAndView RentHouse(HttpServletRequest request, HttpServletResponse response,
		@RequestParam(value="houseId",required = true) String h) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("HouseRent");
		
		String houseID=h;
	    House H= ihs.serachhouseById(houseID);
		Integer HouseTypecode=H.gethType();
		String HouseType=null;
		   if(HouseTypecode==1){
			   HouseType="apartment";
		   }else if(HouseTypecode==2){
			   HouseType="compound apartment";
		   }else if(HouseTypecode==3){
			   HouseType="low block";
		   }else if(HouseTypecode==4){
			   HouseType="mansion";
		   }else if(HouseTypecode==5){
			   HouseType="datcha";
		   }
		   mv.addObject("house", H);
		   mv.addObject("houseTypre",HouseType);
		return mv;
	}
	@PostMapping("/HouseRent")
	public ModelAndView RentBuild(HttpServletRequest request, HttpServletResponse response,
		@RequestParam(value="StartDate") String start,
		@RequestParam(value="EndDate") String end,
		@RequestParam(value="money") String money,
		@RequestParam(value="houseId") String h) throws Exception {
		User user = (User)request.getSession().getAttribute("u");
		Integer hID=Integer.parseInt(h);
	    Integer ID=user.getuId();
        Date StartDate=null;
	    Date EndDate=null;
	    
	    AbstractFactory ConverterFactory = FactoryProducer.getFactory("Converter");
	    AbstractFactory VaildatorFactory = FactoryProducer.getFactory("Validator");
		Converter dateCon = ConverterFactory.getConverter("DATE");
	    Validator nullValidator = VaildatorFactory.getValidator("isNull");
		StringBuffer msg = new StringBuffer();
		if(ID==null) {
			msg.append("You must log in before you rent a house");
			ModelAndView mv1 = RentHouse(request, response,h);
			mv1.addObject("msg", msg.toString());
			mv1.setViewName("HouseRent");
			return mv1;
		}
		if(nullValidator.verifi(start)||nullValidator.verifi(end)) {
			msg.append("The required information is incomplete!");
			ModelAndView mv2 = RentHouse(request, response,h);
			mv2.addObject("msg", msg.toString());
			mv2.setViewName("HouseRent");
			return mv2;
		}
        if(nullValidator.verifi(money)) {
        	msg.append("You must enter an amount for the homeowner's reference");
			ModelAndView mv3 = RentHouse(request, response,h);
			mv3.addObject("msg", msg.toString());
			mv3.setViewName("HouseRent");
			return mv3;
        }
		StartDate = dateCon.convertString(start);
		EndDate = dateCon.convertString(end);
		Integer mon=Integer.parseInt(money);
		
		if(EndDate.compareTo(StartDate)<=0) {
			msg.append("The end date needs to be after the start date!");
			ModelAndView mv1 = RentHouse(request, response,h);
			mv1.addObject("msg", msg.toString());
			mv1.setViewName("HouseRent");
			return mv1;
		}
		Date nowTime=new Date(System.currentTimeMillis());
		if(StartDate.compareTo(nowTime)<=0) {
			msg.append("The start date needs to be after current time!");
			ModelAndView mv1 = RentHouse(request, response,h);
			mv1.addObject("msg", msg.toString());
			mv1.setViewName("HouseRent");
			return mv1;
		}
		if(EndDate.compareTo(nowTime)<=0) {
			msg.append("The end date needs to be after current time!");
			ModelAndView mv1 = RentHouse(request, response,h);
			mv1.addObject("msg", msg.toString());
			mv1.setViewName("HouseRent");
			return mv1;
		}
		
		Rental rent=new Rental();
		rent.setrUId(ID);
		rent.setrHId(hID);
		rent.setrStart(StartDate);
		rent.setrEnd(EndDate);
		rent.setrPrice( mon);

		
		String realPath = request.getSession().getServletContext().getRealPath("/");
		FrameWork framework = FrameWork.getInstance();
		framework.handleRequest(new RentContext(rent,realPath));
		
		
		
		IRentService rentHouseproxy =  (IRentService) InterceptorJdkProxy.bind(irs,new SendApplicationProxy());
		Boolean result=rentHouseproxy.insertRent(rent);
		if(result==true) {
			msg.append("You have successfully send a rent message to owner,please wait for reply");
			ModelAndView mv1 = RentHouse(request, response,h);
			mv1.addObject("msg", msg.toString());
			mv1.setViewName("HouseRent");
			return mv1;
		}else {
			msg.append("Can't make a rental,please try again");
			ModelAndView mv1 = RentHouse(request, response,h);
			mv1.addObject("msg", msg.toString());
			mv1.setViewName("HouseRent");
			return mv1;
		}
	}

}
