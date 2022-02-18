package com.restapi.helpers;

import com.restapi.utility.ReadPropertyFile;

public class UserServiceHelper {
	
	
	
	protected static String getBaseURI() {
		return ReadPropertyFile.readProperty("baseURI");
	}
	
//	protected 
	
	
}
