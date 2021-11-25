package com.cg.dms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.CompanyPayment;
import com.cg.dms.entities.CustomerPayment;
import com.cg.dms.entities.DealerPayment;
import com.cg.dms.entities.Payment;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.exception.CustomerNotFoundException;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.exception.PaymentAlreadyFoundException;
//import com.cg.dms.exception.PaymentNotFoundException;
import com.cg.dms.repository.ICompanyPaymentRepository;
import com.cg.dms.repository.ICustomerPaymentRepository;
import com.cg.dms.repository.IDealerPaymentRepository;
import com.cg.dms.repository.IPaymentRepository;
//import com.cg.spring.boot.demo.model.Employee;

@Service
public class PaymentService {
	private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	private IPaymentRepository ipaymentrepository;
	@Autowired
	private IDealerPaymentRepository idealerpaymentrepo;
	@Autowired
	private ICompanyPaymentRepository icompanypaymentrepository;
	@Autowired
	private ICustomerPaymentRepository icustomerpaymentrepository;


//	public Payment insertDealerToComapnyPayment(Payment payment)throws PaymentNotFoundException;
	public Payment insertDealerToComapnyPayment(DealerPayment payment) throws PaymentAlreadyFoundException {
		LOG.info("Insert Dealer to Company Payment");
		Optional<DealerPayment> dealer = idealerpaymentrepo.findById(payment.getPaymentId());
		if (dealer.isPresent()) {
			throw new PaymentAlreadyFoundException(payment.getPaymentId() + " PaymentId already found");
		} else {
			LOG.info("Insert dealer into company payment");
			return ipaymentrepository.save(payment);
		}

	}

	public Payment insertCompanyToFarmerPayment(CompanyPayment payment) throws PaymentAlreadyFoundException {

		LOG.info("Insert Comapany To Farmer ");
		Optional<CompanyPayment> company = icompanypaymentrepository.findById(payment.getPaymentId());
		if (company.isPresent()) {
			throw new PaymentAlreadyFoundException(payment.getPaymentId() + "PaymentId already found ");
		} else {
			LOG.info("Insert company into farmer payment");
			return icompanypaymentrepository.save(payment);
		}

	}
	
	public Payment insertCustomerToDelearPayment(CustomerPayment payment) throws PaymentAlreadyFoundException{
		LOG.info("Insert Customer to Dealer ");
		Optional<CustomerPayment>  customer = icustomerpaymentrepository.findById(payment.getPaymentId());
		if(customer.isPresent()) {
			throw new PaymentAlreadyFoundException(payment.getPaymentId()+"PaymentId already found");
		}else {
			LOG.info("Insert Customer into Dealer ");
			return icustomerpaymentrepository.save(payment);
		}
	}
		
	public  List<DealerPayment> viewAllPaymentsDealer(int delearId) throws DealerNotFoundException{
		
		List<DealerPayment> dp= new ArrayList<>();
		
		Optional<DealerPayment> empOpt = idealerpaymentrepo.findById(delearId);
		if(empOpt.isPresent()) {
			dp.add(empOpt.get());
			return dp;
		}
		else {
			throw new DealerNotFoundException("Dealer not found");
		}
	}
		
		public  List<CustomerPayment> viewAllPaymentsCustomer(int customerId) throws CustomerNotFoundException{
			
			List<CustomerPayment> dp= new ArrayList<>();
			Optional<CustomerPayment> cp = icustomerpaymentrepository.findById(customerId);
			if(cp.isPresent()) {
				dp.add(cp.get());
				return dp;
			}
			else {
				throw new CustomerNotFoundException("customer not found");
			}
	}
public  List<CompanyPayment> viewAllPaymentsCompany(int companyId) throws CompanyNotFoundException{
			
			List<CompanyPayment> dp= new ArrayList<>();
			
			Optional<CompanyPayment> cp = icompanypaymentrepository.findById(companyId);
			if(cp.isPresent()) {
				dp.add(cp.get());
				return dp;
			}
			else {
				throw new CompanyNotFoundException("customer not found");
			}
}
	

	
	
	
	
//	public Payment insertCompanyToFarmerPayment(Payment payment)throws PaymentNotFoundException;   --- done
//	public Payment insertDealerToComapnyPayment(Payment payment)throws PaymentNotFoundException;   --- done
//	public Payment insertCustomerToDelearPayment(Payment payment)throws PaymentNotFoundException;  --- done
//	
//	
//	public List<Payment> viewAllpaymentsCustomer(int customerId) throws CustomerNotFoundException;
//	public List<Payment> viewAllpaymentsDealer(int delearId) throws CustomerNotFoundException;
//	public List<Payment> viewAllpaymentsCompany(int companyId) throws CustomerNotFoundException;
//	
//	public Payment calculateBillForCustomer(int customerId)throws CustomerNotFoundException;
//	public Payment calculateBillForDealer(int dealerId)throws CustomerNotFoundException;
//	public Payment calculateBillForCompany(int companyId)throws CustomerNotFoundException;
}
