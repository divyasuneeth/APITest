package com.restapi.CRUD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restapi.basetest.BaseTest;
import com.restapi.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class testLogin extends BaseTest{
	
	@Test(priority = 0)
	public void login_TC() {
		Response res = LoginToApplication();
		res.then().time(Matchers.lessThan(3000L));
		res.then().statusCode(201);
	}
}
