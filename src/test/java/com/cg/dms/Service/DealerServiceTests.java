package com.cg.dms.Service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dms.entities.Dealer;
import com.cg.dms.repository.ICompanyRepository;
import com.cg.dms.repository.IDelearRepository;
import com.cg.dms.service.CompanyService;
import com.cg.dms.service.DelearService;


@SpringBootTest
public class DealerServiceTests {

	@Autowired
	private DelearService dealerService;
	@Autowired
	private CompanyService companyService;
	
	@MockBean
	private IDelearRepository dealerRepository;
	@MockBean
	private ICompanyRepository companyRepository;


	@Test
	public void deletedealById() {
		Dealer dealer	 = dealerRepository.getById( 1);
		dealerRepository.delete(dealer);
		Optional<Dealer> dealerOpt = Optional.empty();
		if (dealerOpt.isPresent()) {
			dealer = dealerOpt.get();
		}
		Assertions.assertThat(dealer) .isNull();
	}
	
	@Test
	public void getdealById() {
		Dealer dealer	 = dealerRepository.getById( 1);
		dealerRepository.getById(2);
		Optional<Dealer> dealerOpt = Optional.empty();
		if (dealerOpt.isPresent()) {
			dealer = dealerOpt.get();
		}
		Assertions.assertThat(dealer) .isNull();
	}
}