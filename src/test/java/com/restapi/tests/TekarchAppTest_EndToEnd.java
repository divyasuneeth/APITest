package com.restapi.tests;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.restapi.basetest.BaseTest;
import com.restapi.helpers.UserServiceHelper;
import com.restapi.models.UserVO;
import com.restapi.utility.GetValueObjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TekarchAppTest_EndToEnd extends BaseTest {

	private static List<UserVO> listUser;
	private static UserVO user;

	@Test(priority = 0)
	public void login() {
		Response res = UserServiceHelper.LoginToApplication();
		res.then().time(Matchers.lessThan(3000L));
		res.then().statusCode(201);	
	}

	@Test
 	public void getAllUser() {
		Header header = new Header("token", getToken());
		RequestSpecification req = RestAssured.given();
		req.header(header).contentType(ContentType.JSON);
		Response res = req.get("/getdata");
		res.then().statusCode(200);

	}

	@Test
	public void testAddUser() {
		Header header = new Header("token", getToken());
		user = GetValueObjects.getUser();
		Response res = RestAssured.given().header(header).contentType(ContentType.JSON).body(user).post("/addData");
		res.then().statusCode(201);
		res.then().body(containsString("success"));
		res = RestAssured.given().header(header).get("/getdata");
		listUser = res.jsonPath().getList("$", UserVO.class);
		for (UserVO u : listUser) {
			if (u.getAccountno().equalsIgnoreCase(user.getAccountno())) {
				user.setUserid(u.getUserid());
				user.setId(u.getId());

			}
		}

		System.out.println(user.getUserid());
		System.out.println(user.getId());
	}

	@Test(dependsOnMethods = { "testAddUser" })
	public void testDeleteUser() {

		Header header = new Header("token", getToken());
		Response res = RestAssured.given().header(header).contentType(ContentType.JSON).body(user)
				.delete("/deleteData");
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(3000L));
		res.then().body(containsString("success"));

	}

	@Test(dependsOnMethods = { "testAddUser" }, priority = 1)
	public void testUpdateUser() {
		Header header = new Header("token", getToken());
		user.setSalary("7777");
		Response res = RestAssured.given().header(header).contentType(ContentType.JSON).body(user).put("/updateData");
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(3000L));
		res.then().body(containsString("success"));

		res = RestAssured.given().header(header).get("/getdata");
		listUser = res.jsonPath().getList("$", UserVO.class);
		for (UserVO u : listUser) {
			if (u.getAccountno().equalsIgnoreCase(user.getAccountno())) {
				System.out.println(u.toString());

			}
		}

	}

}
