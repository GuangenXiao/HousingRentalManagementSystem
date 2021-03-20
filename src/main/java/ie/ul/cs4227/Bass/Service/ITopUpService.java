package ie.ul.cs4227.Bass.Service;

import java.util.ArrayList;

import ie.ul.cs4227.Bass.Entity.Recharge;
import ie.ul.cs4227.Bass.Entity.User;

public interface ITopUpService {
 public abstract Boolean TopUp(User u,Integer amount,String type) ;
 public abstract ArrayList<Recharge> getTopUpList() ;
 public abstract Recharge selectTopUpById(Integer tId) ;
}
