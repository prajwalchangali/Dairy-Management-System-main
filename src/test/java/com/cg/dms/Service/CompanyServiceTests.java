package com.cg.dms.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dms.entities.Company;
import com.cg.dms.repository.ICompanyRepository;
import com.cg.dms.service.CompanyService;


@SpringBootTest
public class CompanyServiceTests {

	@Autowired
	private CompanyService companyService;
	
	@MockBean
	private ICompanyRepository companyRepository;

	@Test
	public  void addcompany() {

		Company company  =  new Company ((int)10,(String)"sonu",(String)"S@123",(String)"1234@12",(String)"8133245643",(String)"chennai");
		when(companyRepository.save(company)).thenReturn(company);
		assertEquals(company, companyService.insertCompany(company));
	}


	@Test
	public void deletecompanyById() {
		Company company = companyRepository.getById( 1);
		companyRepository.delete(company);
		Optional<Company> comapnyOpt = Optional.empty();
		if (comapnyOpt.isPresent()) {
			company = comapnyOpt.get();
		}
		Assertions.assertThat(company).isNull();
	}
}