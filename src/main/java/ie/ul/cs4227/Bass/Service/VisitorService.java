package ie.ul.cs4227.Bass.Service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.ul.cs4227.Bass.Dao.VisitorDao;
import ie.ul.cs4227.Bass.Entity.Visitor;

@Service
public class VisitorService implements IVisitorService{
	
	@Autowired
	@Resource
	VisitorDao Vd;
	
	@Override
	public Integer insertVisitor(Visitor v) {
		Integer result=null;
		try {
			result = Vd.insertVisitor(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public ArrayList<Visitor> getVisitor(){
		ArrayList<Visitor> list=null;
		 try {
				list= Vd.getVisitors();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return list;
	}
}
