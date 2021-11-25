package com.cg.dms.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.CompanyPayment;
import com.cg.dms.entities.CustomerPayment;
import com.cg.dms.entities.DealerPayment;
import com.cg.dms.entities.Payment;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.exception.CustomerNotFoundException;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.service.PaymentService;


@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentservice;

	private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
	
	@PostMapping("/set_dealer_tocmpy")
	public ResponseEntity<Payment> insertDealerToCompany(@RequestBody DealerPayment payment){
		LOG.info("insert Dealer to company");
		Payment pay = paymentservice.insertDealerToComapnyPayment(payment);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "New dealer Payment is added");
		ResponseEntity<Payment> response = new ResponseEntity<Payment>(pay,headers,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/set_cmpy_tofarm")
	public ResponseEntity<Payment> insertCompanyToFarmer(@RequestBody CompanyPayment payment){
		LOG.info("insert company to farmer");
		Payment pay = paymentservice.insertCompanyToFarmerPayment(payment);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "New Farmer payment is added");
		ResponseEntity<Payment> response = new ResponseEntity<Payment>(pay,headers,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/set_custom_to_dealer")
	public ResponseEntity<Payment> insertCustomerToDealer(@RequestBody CustomerPayment payment){
		LOG.info("insert customer to Dealer");
		Payment pay = paymentservice.insertCustomerToDelearPayment(payment);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "New Customer Payment is added");
		ResponseEntity<Payment> response = new ResponseEntity<Payment>(pay,headers,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/viewpaybyId/{delearId}")
	public ResponseEntity<List<DealerPayment>> viewAllpaymentsDealer(@PathVariable(name = "delearId")int delearId) throws DealerNotFoundException{
		LOG.info("view dealer");

		HttpHeaders headers = new HttpHeaders();
		List<DealerPayment> dp= new ArrayList<>();
		headers.add("message", "Dealers Payments Found by This Id");
		dp=paymentservice.viewAllPaymentsDealer(delearId);
		ResponseEntity<List<DealerPayment>> response = new ResponseEntity<List<DealerPayment>>(dp,headers,HttpStatus.OK);
		return response;
		
	}
	@GetMapping("/viewpaybycustomId/{customerId}")
	public ResponseEntity<List<CustomerPayment>> viewAllPaymentsCustomer(@PathVariable(name = "customerId")int customerId) throws CustomerNotFoundException{
		LOG.info("view dealer");

		HttpHeaders headers = new HttpHeaders();
		List<CustomerPayment> dp= new ArrayList<>();
		headers.add("message", "Dealers Payments Found by This Id");
		dp=paymentservice.viewAllPaymentsCustomer(customerId);
		ResponseEntity<List<CustomerPayment>> response = new ResponseEntity<List<CustomerPayment>>(dp,headers,HttpStatus.OK);
		return response;
		
	}

	@GetMapping("/viewpaybycompanyId/{companyId}")
	public ResponseEntity<List<CompanyPayment>> viewAllPaymentsCompany(@PathVariable(name = "companyId")int companyId) throws CompanyNotFoundException{
		LOG.info("view dealer");

		HttpHeaders headers = new HttpHeaders();
		List<CompanyPayment> dp= new ArrayList<>();
		headers.add("message", "Dealers Payments Found by This Id");
		dp=paymentservice.viewAllPaymentsCompany(companyId);
		ResponseEntity<List<CompanyPayment>> response = new ResponseEntity<List<CompanyPayment>>(dp,headers,HttpStatus.OK);
		return response;
		
	}
}









