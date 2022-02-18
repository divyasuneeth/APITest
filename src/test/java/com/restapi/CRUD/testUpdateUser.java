package com.restapi.CRUD;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restapi.basetest.BaseTest;
import com.restapi.helpers.UserServiceHelper;
import com.restapi.models.UserVO;

import io.restassured.response.Response;

public class testUpdateUser extends BaseTest {

	@Test(dependsOnMethods = { "testAddUser" }, priority = 1)
	public void updateUser_TC() {
		Response res = UserServiceHelper.addUser();
		res = UserServiceHelper.updateUser();
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(3000L));
		res.then().body(containsString("success"));

		List<UserVO> listUser = UserServiceHelper.getAllUserData();
		for (UserVO u : listUser) {
			if (u.getAccountno().equalsIgnoreCase(user.getAccountno())) {
				System.out.println(u.toString());

			}
		}

	}
}
