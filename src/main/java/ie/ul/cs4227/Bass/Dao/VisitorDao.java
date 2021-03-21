package ie.ul.cs4227.Bass.Dao;

import java.util.ArrayList;

import ie.ul.cs4227.Bass.Entity.Visitor;

public interface VisitorDao {
 public abstract Integer insertVisitor(Visitor v);
 public abstract ArrayList<Visitor> getVisitors();
}
