package com.cg.dms.service;

import com.cg.dms.entities.Login;

public interface ILoginService {
	
	Login registerUser(Login user);
	Login login(String username, String password);

}
