package ie.ul.cs4227.Bass.Service;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ie.ul.cs4227.Bass.HrmsApplication;
import ie.ul.cs4227.Bass.Entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HrmsApplication.class)
public class loginTest {

	@Autowired
	@Resource
	IUserService us = new UserService();

	@Test
	public void testUserLogin() {
		User u =new User.Builder().uId(1).uPassword("123456").Build();
		assertEquals(u.getuId(),us.UserLogin(u).getuId());
	}

	@Test
	public void testFindUsers() {
		assertEquals(true,us.findUsers("","General").size()>0);
	}

}
