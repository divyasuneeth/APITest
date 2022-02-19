package com.restapi.helpers;

import java.util.List;

import com.restapi.models.UserVO;
import com.restapi.utility.GetValueObjects;

public class ReusableMethod {
  public static UserVO getUserFromResponse() {
	  UserVO user= GetValueObjects.getUser();
	  List<UserVO> listUser = UserServiceHelper.getAllUserData();
		for (UserVO u : listUser) {
			if (u.getAccountno().equalsIgnoreCase(user.getAccountno())) {
				user=u;
			}
		}
	  return user;
  }
}
