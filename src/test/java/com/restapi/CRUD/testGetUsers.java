package com.restapi.CRUD;

import org.testng.annotations.Test;

import com.restapi.basetest.BaseTest;
import com.restapi.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class testGetUsers extends BaseTest {

	@Test
	public void testGetAllUser() {
		Response res = UserServiceHelper.getUsers();
		res.then().statusCode(200);

	}
}
