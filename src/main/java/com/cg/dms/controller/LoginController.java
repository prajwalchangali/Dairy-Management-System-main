package com.cg.dms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.Login;
import com.cg.dms.service.LoginService;


@RestController
public class LoginController {
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService userService;

	@PostMapping("/register")
	public ResponseEntity<Login> register(@RequestBody Login user) {
	LOG.info("Controller register");
	Login us = userService.registerUser(user); // line 
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "This user is added to the database.");
	LOG.info(headers.toString());
	ResponseEntity<Login> response = new ResponseEntity<>(us, headers, HttpStatus.OK);
	return response;
}

	

	@PutMapping("/login/{usname}/{pass}")
	public ResponseEntity<Login> login(@PathVariable(name="usname" ) String UserName,@PathVariable(name="pass") String Password) {
	LOG.info("Controller Login");
	Login us = userService.login(UserName, Password); // line 
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "This user is added to the database.");
	LOG.info(headers.toString());
	ResponseEntity<Login> response = new ResponseEntity<Login>(us, headers, HttpStatus.OK);
	return response;
}

//	@GetMapping("/forgot password")
//	public ResponseEntity<User> forgotpassword(@RequestBody User user) {
//	LOG.info("Controller fogotpassword");
//	//User us = userService.forgotpassword(user); // line 
//	HttpHeaders headers = new HttpHeaders();
//	headers.add("message", "This user is added to the database.");
//	LOG.info(headers.toString());
//	ResponseEntity<User> response = new ResponseEntity<User>(us, headers, HttpStatus.OK);
//	return response;
//}

	
	
	
	}
