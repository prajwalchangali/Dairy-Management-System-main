package com.cg.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.service.CompanyPaymentService;

@RestController
public class CompanyPaymentController {

	@Autowired
	private CompanyPaymentService companyPaymentService;
	
}
