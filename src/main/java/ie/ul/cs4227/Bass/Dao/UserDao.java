package ie.ul.cs4227.Bass.Dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ie.ul.cs4227.Bass.Entity.User;


@Repository
@Mapper

public interface UserDao {
	
	public abstract User searchUserByID(User u)  throws Exception;
	public abstract Integer insertUser(User u)  throws Exception;
	public abstract Integer updateUser(User u)  throws Exception;
	public abstract Integer deleteUser(User u)  throws Exception;
	public abstract ArrayList<User> findUsers(@Param(value="info")String info,@Param(value="type")String type) throws Exception;
	public abstract User searchUserByName(User u)  throws Exception;
}
