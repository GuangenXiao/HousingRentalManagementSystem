package ie.ul.cs4227.Bass.Dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ie.ul.cs4227.Bass.Entity.Visitor;
@Repository
@Mapper
public interface VisitorDao {
 public abstract Integer insertVisitor(Visitor v);
 public abstract ArrayList<Visitor> getVisitors();
}
