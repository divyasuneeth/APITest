package com.restapi.CRUD;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restapi.basetest.BaseTest;
import com.restapi.helpers.UserServiceHelper;
import com.restapi.models.UserVO;
import com.restapi.utility.GetValueObjects;

import io.restassured.response.Response;

public class testDeleteUser extends BaseTest {
	@Test
	public void deleteUser_TC() {
		Response res = UserServiceHelper.LoginToApplication();
		user = GetValueObjects.getUser();
		List<UserVO> listUser = UserServiceHelper.getAllUserData();
		for (UserVO u : listUser) {
			if (u.getAccountno().equalsIgnoreCase(user.getAccountno())) {
				user=u;
			}
		}
		res = UserServiceHelper.deleteUser();
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(3000L));
		res.then().body(containsString("success"));

	}
}
