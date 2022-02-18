package com.restapi.CRUD;

import static org.hamcrest.CoreMatchers.containsString;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restapi.basetest.BaseTest;
import com.restapi.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class testDeleteUser extends BaseTest {
	@Test
	public void deleteUser_TC() {

		Response res = UserServiceHelper.addUser();
		res = UserServiceHelper.deleteUser();
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(3000L));
		res.then().body(containsString("success"));

	}
}
