package ie.ul.cs4227.Bass.Dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ie.ul.cs4227.Bass.Entity.Recharge;

@Repository
@Mapper
public interface TopUpDao {

	public abstract Integer topUp(Recharge r);
	public abstract ArrayList<Recharge> selectTopUpList();
	public abstract Recharge selectTopUp(Integer orderNumber);
	
}
