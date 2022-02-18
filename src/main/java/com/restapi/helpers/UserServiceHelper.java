package com.restapi.helpers;

import java.util.List;

import com.restapi.constants.EndPoints;
import com.restapi.models.Login;
import com.restapi.models.UserVO;
import com.restapi.utility.GetValueObjects;
import com.restapi.utility.ReadPropertyFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UserServiceHelper {

	protected static Response res;
	protected static String token;
	protected static UserVO user;

	protected static String getBaseURI() {
		return ReadPropertyFile.readProperty("baseURI");
	}

	protected static Response LoginToApplication() {
		Login login = GetValueObjects.getLogin();
		res = RestAssured.given().contentType(ContentType.JSON).body(login).post(EndPoints.LOGIN_URI);
		token = res.jsonPath().get("[0].token");
		return res;
	}

	protected static String getToken() {
		if (token == null)
			LoginToApplication();

		return token;
	}

	protected static List<UserVO> getAllUserData() {
		res = getUsers();
		List<UserVO> listUser = res.jsonPath().getList("$", UserVO.class);
		return listUser;
	}

	protected static Response getUsers() {
		Header header = new Header("token", getToken());
		res = RestAssured.given().header(header).contentType(ContentType.JSON).get(EndPoints.GET_URI);

		return res;
	}

	protected static Response addUser() {
		Header header = new Header("token", getToken());
		user = GetValueObjects.getUser();
		res = RestAssured.given().header(header).contentType(ContentType.JSON).body(user).post(EndPoints.ADD_URI);
		return res;
	}

	protected static Response deleteUser() {
		Header header = new Header("token", getToken());
		res = RestAssured.given().header(header).contentType(ContentType.JSON).body(user).delete(EndPoints.DELETE_URI);
		return res;
	}

	protected static Response updateUser() {
		Header header = new Header("token", getToken());
		user.setSalary("7777");
		res = RestAssured.given().header(header).contentType(ContentType.JSON).body(user).put(EndPoints.UPDATE_URI);
		return res;
	}

}
