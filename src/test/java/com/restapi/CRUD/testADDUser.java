package com.restapi.CRUD;

import static org.hamcrest.CoreMatchers.containsString;

import org.testng.annotations.Test;

import com.restapi.basetest.BaseTest;
import com.restapi.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class testADDUser extends BaseTest {
	@Test
	public void addUser_TC() {
		Response res = LoginToApplication();
		res = addUser();
		res.then().statusCode(201);
		res.then().body(containsString("success"));

//		System.out.println(user.getUserid());
//		System.out.println(user.getId());
	}
}
