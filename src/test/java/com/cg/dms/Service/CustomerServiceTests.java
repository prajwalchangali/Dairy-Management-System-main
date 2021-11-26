package com.cg.dms.Service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dms.entities.Customer;
import com.cg.dms.repository.ICustomerRepository;
import com.cg.dms.service.CustomerService;


	@SpringBootTest
	public class CustomerServiceTests {

		@Autowired
		private CustomerService customerService;
		
		@MockBean
		private ICustomerRepository customerRepository;
		
		@Test
		public void deleteCustomer() {
			Customer customer	 = customerRepository.getById( 1);
			customerRepository.delete(customer);
			Optional<Customer> customerOpt = Optional.empty();
			if (customerOpt.isPresent()) {
				customer = customerOpt.get();
			}
			Assertions.assertThat(customer) .isNull();
		}
		
		@Test
		public void viewCustomer() {
			Customer customer	 = customerRepository.getById( 1);
			customerRepository.getById(1);
			Optional<Customer> customerOpt = Optional.empty();
			if (customerOpt.isPresent()) {
				customer = customerOpt.get();
			}
			Assertions.assertThat(customer) .isNull();
		}	
}