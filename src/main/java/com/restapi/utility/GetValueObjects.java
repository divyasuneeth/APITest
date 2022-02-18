package com.restapi.utility;

import com.restapi.models.Login;
import com.restapi.models.UserVO;

public class GetValueObjects {

	public static UserVO getUser() {
		UserVO user = new UserVO();
		user.setAccountno("TA-9222221");
		user.setDepartmentno("1");
		user.setSalary("4567");
		user.setPincode("950871");
		return user;

	}

	public static Login getLogin() {
		Login login = new Login();
		
		login.setUsername(ReadPropertyFile.readProperty("username"));
		login.setPassword(ReadPropertyFile.readProperty("password"));
		return login;
	}
}
