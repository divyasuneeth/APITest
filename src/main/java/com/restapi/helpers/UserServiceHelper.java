package com.restapi.helpers;

import java.util.List;

import com.restapi.models.Login;
import com.restapi.models.UserVO;
import com.restapi.utility.GetValueObjects;
import com.restapi.utility.ReadPropertyFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserServiceHelper {

	protected static Response res;
	protected static RequestSpecification req;
	protected static String token;

	protected static String getBaseURI() {
		return ReadPropertyFile.readProperty("baseURI");
	}

	protected static Response LoginToApplication() {
		Login login = GetValueObjects.getLogin();
		res = RestAssured.given().contentType(ContentType.JSON).body(login).post("/login");
		token = res.jsonPath().get("[0].token");
		return res;
	}

	protected static String getToken() {
		if (token == null) 
			LoginToApplication();
			
	
		return token;
	}

	protected static List<UserVO> getAllUserData() {
		return null;
	}

	protected static Response addUser() {
		return res;
	}

	protected static Response deleteUser() {
		return res;
	}

	protected static Response updateUser() {
		return res;
	}

}
