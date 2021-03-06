package ie.ul.cs4227.Bass.Service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.ul.cs4227.Bass.Dao.UserDao;
import ie.ul.cs4227.Bass.Entity.User;

@Service
public class UserService implements IUserService {

	@Autowired
	@Resource
	UserDao ud;

	public UserService() {

	}

	@Override
	public User UserLogin(User u) {

		User uResult = null;
		try {
			uResult = ud.searchUserByID(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uResult;

	}

	@Override
	public ArrayList<User> findUsers(String info, String type) {
		if (type.equals("General"))
			type = null;
		else if (type.equals("Administrator"))
			type = "admin";
		else if (type.equals("Normal User"))
			type = "user";
		else if (type.equals("Houser Owner"))
			type = "owner";
		else
			type = null;

		ArrayList<User> list = null;
		try {
			list = ud.findUsers(info, type);
		} catch (Exception e) {
		}

		return list;
	}

	@Override
	public Integer updateUser(User u) {

		Integer r = null;
		try {
			r = ud.updateUser(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Integer insertUser(User u) {

		Integer r = null;
		try {
			r = ud.insertUser(u);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	public User registerNewUser(User u) {
		Integer b = 0;
		try {
			b = ud.insertUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b == 0)
			return null;
		else {
			User result = fineUserByName(u);
			return result;
		}
	}

	@Override
	public User fineUserByName(User u) {
		User uResult = null;
		try {
			uResult = ud.searchUserByName(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uResult;
	}

}
