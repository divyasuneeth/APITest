package com.restapi.CRUD;

import static org.hamcrest.CoreMatchers.containsString;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restapi.basetest.BaseTest;
import com.restapi.helpers.ReusableMethod;
import com.restapi.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class testUpdateUser extends BaseTest {

	@Test
	public void updateUser_TC() {

		Response res = LoginToApplication();
		user = ReusableMethod.getUserFromResponse();
		res=updateUser();
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(3000L));
		res.then().body(containsString("success"));

		
	}
}
