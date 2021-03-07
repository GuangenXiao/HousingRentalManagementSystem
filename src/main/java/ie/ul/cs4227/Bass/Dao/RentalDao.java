package ie.ul.cs4227.Bass.Dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ie.ul.cs4227.Bass.Entity.Rental;

@Repository
@Mapper
public interface RentalDao {
	public abstract Integer insertRental(Rental R) throws Exception;
	public abstract ArrayList<Rental> findrentals(Integer owner)throws Exception;
	public abstract Integer updateRental(Integer rentalID)throws Exception;
	public abstract Integer deteleRental(Integer rentalID)throws Exception;
}
