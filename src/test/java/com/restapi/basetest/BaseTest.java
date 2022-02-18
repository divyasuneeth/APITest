package com.restapi.basetest;

import org.testng.annotations.BeforeClass;

import com.restapi.utility.ReadPropertyFile;

import io.restassured.RestAssured;

public class BaseTest {
	protected static String token;
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = ReadPropertyFile.readProperty("baseURI");
	}
	
}
