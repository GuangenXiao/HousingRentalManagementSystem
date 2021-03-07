package ie.ul.cs4227.Bass.Controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ie.ul.cs4227.Bass.Entity.House;
import ie.ul.cs4227.Bass.Entity.HouseType;
import ie.ul.cs4227.Bass.Entity.User;
import ie.ul.cs4227.Bass.Service.HouseService;
import ie.ul.cs4227.Bass.Service.IHouseService;


@RestController
public class HouseControllor {
///HouseMangeServlet
///HouseServlet
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
		ArrayList<House> list =ihs.findHouses(houseinfo,index);
		mv.addObject("houselist", list);
		mv.setViewName("searchlist");
		return mv;
	}
}
