package ie.ul.cs4227.Bass.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ie.ul.cs4227.Bass.Entity.House;
import ie.ul.cs4227.Bass.Entity.HouseType;
import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Service.HouseService;
import ie.ul.cs4227.Bass.Service.IHouseService;
import ie.ul.cs4227.Bass.Service.IUserService;
import ie.ul.cs4227.Bass.Service.Interceptor.InterceptorJdkProxy;
import ie.ul.cs4227.Bass.Service.Interceptor.SearchUserInterceptor;
import ie.ul.cs4227.Bass.Util.AbstractFactory;
import ie.ul.cs4227.Bass.Util.Converter;
import ie.ul.cs4227.Bass.Util.FactoryProducer;
import ie.ul.cs4227.Bass.Util.Tools;


@RestController
public class HouseControllor {

///SearchHouseServlet
	@Resource
	IHouseService ihs = new HouseService();
	
	@GetMapping("/SearchHouse")
	public ModelAndView searchHousePage(HttpServletRequest request, 
			HttpServletResponse response
			) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchlist");
		ArrayList<HouseType> typelist =ihs.findHTypes(); 
		mv.addObject("typelist", typelist);
		return mv;
	}
	@PostMapping("/SearchHouse")
	public ModelAndView searchHouse(HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value="HouseTypeSelect",required = true) String housetype,
			@RequestParam(value="HouseInfo",required = true)String houseinfo
			) throws Exception {
		Integer  index =null;
		ModelAndView mv =new ModelAndView();
		ArrayList<HouseType> typelist =ihs.findHTypes(); 
		mv.addObject("typelist", typelist);
		if(housetype!=null)
		{
			String [] parts= housetype.split("---");
			index = Integer.parseInt(parts[0]); 
			if(index==0)index=null;
		}
		if(index==null&&houseinfo.length()<=0) 
		{
			mv.setViewName("searchlist");
			return mv;
		}
		IHouseService findHousesProxy =(IHouseService) InterceptorJdkProxy.bind(ihs,new SearchUserInterceptor());
		ArrayList<House> list =findHousesProxy.findHouses(houseinfo,index);
		mv.addObject("houselist", list);
		mv.setViewName("searchlist");
		return mv;
	}
	///HouseServlet
	@GetMapping("/NewHouse")
	public ModelAndView NewHouse(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NewHouse");
		String msg =null;
		  if(request.getAttribute("msg")!=null)
		  {
		  	msg=request.getAttribute("msg").toString();
		  }
		mv.addObject("msg",msg);
		return mv;
	}
	@PostMapping("/NewHouse")
	public ModelAndView NewHousePost(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="HouseType",required = false) String HouseType,
			@RequestParam(value="HouseEnergy",required = false) String HouseEnergy,
			@RequestParam(value="HouseAddress",required = false) String HouseAddress,
			@RequestParam(value="HouseParknumber",required = false) String HouseParknumber,
			@RequestParam(value="HouseBirthday",required = false) String HouseBirthday,
			@RequestParam(value="houseEquipment",required = false) String houseEquipment,
			@RequestParam(value="houseDescription",required = false) String houseDescription,
			@RequestParam(value="Housesize",required = false) String Housesize,
			@RequestParam(value="Picture of house",required = false) MultipartFile file) throws Exception {
		    
		    ModelAndView mv = new ModelAndView();
			StringBuffer msg = new StringBuffer();
		    House house = new House();
		    //set features
		    house.sethType(Integer.parseInt(HouseType));
			house.sethEnergy(HouseEnergy);
			house.sethAddress(HouseAddress);
		    house.sethPark(Integer.parseInt(HouseParknumber));
		    house.sethDescription(houseDescription);
			house.sethEquipment(houseEquipment);
			house.sethSize(Integer.parseInt(Housesize));
			
			AbstractFactory ToolFactory = FactoryProducer.getFactory("Tools");
		    Tools filetool= ToolFactory.getTools("FileUpLoad");
			String fileName = file.getOriginalFilename();
	        String filePath = request.getSession().getServletContext().getRealPath("/Recource/");
	        try {
	        	    filetool.uploadfile(file.getBytes(), filePath, fileName);
	        } catch (Exception e) {
	        } 
			house.sethPicture(fileName);
			
			AbstractFactory ConverterFactory = FactoryProducer.getFactory("Converter");
		    Converter dateCon = ConverterFactory.getConverter("DATE");
			Date HouseBirth=dateCon.convertString(HouseBirthday);
			house.sethDate(HouseBirth);
			
			User user = (User)request.getSession().getAttribute("u");
	        Integer ID=user.getuId();
	        house.sethOwnerId(ID);
	        
			Boolean result=ihs.insertHouse(house);
			if(result!=null) {
				msg.append("You have successfully added a new house");
				mv.addObject("msg", msg.toString());
				mv.setViewName("NewHouse");
				return mv;
			}
			else
			{
				msg.append("An error has occurred");
				mv.addObject("msg", msg.toString());
				mv.setViewName("NewHouse");
				return mv;
			}
	}
	@GetMapping("/HouseManage")
	public ModelAndView ManageHouse(HttpServletRequest request, HttpServletResponse response,
		@RequestParam(value="houseId",required = true) String h) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("HouseManage");
		
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
	@PostMapping("/HouseManage")
	public ModelAndView DeleteHouse(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="houseId",required = true) String h) throws IOException {
		String houseID=h;
		ModelAndView mv = new ModelAndView();
		boolean flag = false;
		
		try {
			
			flag = ihs.deleteHouse(Integer.parseInt(houseID));
		}catch (Exception e) {
			// TODO: handle exception
		}		
		if(flag) {
			response.getWriter().write("<script   language=javascript>alert('Modify Successfully');</script>");
			mv.setViewName("index");
			return mv;
		}
		else 
		{
			response.getWriter().write("<script   language=javascript>alert('Modify Fail');'</script>");
			return ManageHouse(request, response,h);
		}
	}
}
