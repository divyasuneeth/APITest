package com.restapi.CRUD;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.List;

import org.testng.annotations.Test;

import com.restapi.basetest.BaseTest;
import com.restapi.helpers.UserServiceHelper;
import com.restapi.models.UserVO;

import io.restassured.response.Response;

public class testADDUser extends BaseTest {
	@Test
	public void testAddUser() {

		Response res = UserServiceHelper.addUser();
		res.then().statusCode(201);
		res.then().body(containsString("success"));

		List<UserVO> listUser = UserServiceHelper.getAllUserData();

		for (UserVO u : listUser) {
			if (u.getAccountno().equalsIgnoreCase(user.getAccountno())) {
				user.setUserid(u.getUserid());
				user.setId(u.getId());

			}
		}

//		System.out.println(user.getUserid());
//		System.out.println(user.getId());
	}
}
