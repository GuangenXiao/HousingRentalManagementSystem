package ie.ul.cs4227.Bass.Dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ie.ul.cs4227.Bass.Entity.House;
import ie.ul.cs4227.Bass.Entity.HouseType;


@Repository
@Mapper
public interface HouseDao {
	public  abstract ArrayList<House> findHouses(@Param(value="info")String info,@Param(value="type")Integer Type) throws Exception ;
	public  abstract ArrayList<HouseType> findHTypes() throws Exception;
	public  abstract Boolean insertHouse(House h) throws Exception;
	public  abstract House searchHouseByID(House h) throws Exception;
	public  abstract Boolean deleteHouse(Integer houseId)throws Exception;
}
