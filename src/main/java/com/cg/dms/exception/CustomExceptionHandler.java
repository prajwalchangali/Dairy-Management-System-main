package com.cg.dms.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class CustomExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFoundException() {

		LOG.error("handleEmployeeNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Customer data not foudnd");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<Object> handleCustomerAlreadyExistsException() {

		LOG.error("handleCustomerAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Customer data already exists in database");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<Object> handleCompanyNotFoundException() {

		LOG.error("handleCompanyNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Company data not found");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CompanyAlreadyExistsException.class)
	public ResponseEntity<Object> handleCompanyAlreadyExistsException() {

		LOG.error("handleCompanyAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Company already exists");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DealAlreadyExistsException.class)
	public ResponseEntity<Object> handleDealAlreadyExistsException() {
		LOG.error("handleDealAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Dealer already exists");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DealerNotFoundException.class)
	public ResponseEntity<Object> handleDealerNotFoundException() {
		LOG.error("handleDealerNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Dealer not found ");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PaymentAlreadyFoundException.class)
	public ResponseEntity<Object> handlePaymentAlreadyFoundException() {
		LOG.error("handlePaymentAlreadyFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "PaymentId already found");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<Object> handlePaymentNotFoundException() {
		LOG.error(" handlePaymentNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Payment Not Found");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodNotFoundException(MethodArgumentNotValidException e) {

		String errMsg=e.getAllErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.joining(","));
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", errMsg);
		return new ResponseEntity<Object>(null, headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FarmerAlreadyExistsException.class)
	public ResponseEntity<Object> FarmerAlreadyExistsException() {
		LOG.error("FarmerAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Farmer is already exists in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FarmerNotFoundException.class)
	public ResponseEntity<Object> handleFarmerNotFoundException() {
		LOG.error("handleFarmerNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Farmer is not Found ");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AppUserNotFoundException.class)
	public ResponseEntity<Object> handleAppUserNotFoundException() {
		LOG.error("AppUserNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Farmer is not Found");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AppUserAlreadyExistsException.class)
	public ResponseEntity<Object> handleAppUserAlreadyExistsException() {
		LOG.error("handleAppUserAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("", null);
		return null;
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Object> UserAlreadyExistsException() {
		LOG.error("UserAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This user already is exists in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(IncorrectLoginCredentialsException.class)
	public ResponseEntity<Object> IncorrectLoginCredentialsException() {
		LOG.error("IncorrectAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Incorrect login crediti");
		return new ResponseEntity<Object>(null, headers, HttpStatus.BAD_GATEWAY);
	}
	
	

}
