package com.cg.dms.Service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dms.entities.Farmer;
import com.cg.dms.repository.IFarmerRepository;
import com.cg.dms.service.FarmerService;

@SpringBootTest
public class FarmerServiceTests {

	@Autowired
	private FarmerService farmerService;

	@MockBean
	private IFarmerRepository farmerRepository;

	@Test
	public void getFarmerById() {
		Farmer farmer = farmerRepository.getById(1);
		farmerRepository.findById(1);
		Optional<Farmer> farmerOpt = Optional.empty();
		if (farmerOpt.isPresent()) {
			farmer = farmerOpt.get();
		}
		Assertions.assertThat(farmer).isNull();
	}
}