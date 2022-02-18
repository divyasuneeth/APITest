package com.restapi.basetest;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {
	protected static String token;
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	}
	
}
