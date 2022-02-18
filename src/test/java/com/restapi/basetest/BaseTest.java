package com.restapi.basetest;

import org.testng.annotations.BeforeClass;

import com.restapi.helpers.UserServiceHelper;

import io.restassured.RestAssured;

public class BaseTest extends UserServiceHelper {
	protected static String token;

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = getBaseURI();
	}

}
