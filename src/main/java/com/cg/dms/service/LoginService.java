package com.cg.dms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.Login;
import com.cg.dms.exception.CustomerAlreadyExistsException;
import com.cg.dms.exception.IncorrectLoginCredentialsException;
import com.cg.dms.repository.ILoginRepository;

@Service
public class LoginService implements ILoginService {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private ILoginRepository userRepository;
	
	private Login tempuser;
	private Login temppassword;
	private Boolean isLoggedIn;
	
	public Login registerUser(Login user) {
		LOG.info("register");
		if (userRepository.findByUserName(user.getUserName()) != null) {
			throw new CustomerAlreadyExistsException();

		} else {
			return userRepository.save(user);
		}
	}
	
	public Login login(String username, String password) throws IncorrectLoginCredentialsException {
		LOG.info("login");
		this.tempuser = userRepository.findByUserName(username);
		this.temppassword = userRepository.findByUserPassword(tempuser.getUserPassword());
		if (tempuser.getUserName().equalsIgnoreCase(username) && temppassword.getUserPassword().equals(password)) {
			isLoggedIn = true;
			return tempuser;
		} else
			throw new IncorrectLoginCredentialsException();
	}

}
