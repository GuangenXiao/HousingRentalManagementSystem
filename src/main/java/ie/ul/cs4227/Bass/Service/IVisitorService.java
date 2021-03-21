package ie.ul.cs4227.Bass.Service;

import java.util.ArrayList;

import ie.ul.cs4227.Bass.Entity.Visitor;

public interface IVisitorService {
	 public abstract Integer insertVisitor(Visitor v); 
	 public abstract ArrayList<Visitor> getVisitor();
}
