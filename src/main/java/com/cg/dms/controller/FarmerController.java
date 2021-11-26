package com.cg.dms.controller;

import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.exception.FarmerAlreadyExistsException;
import com.cg.dms.exception.FarmerNotFoundException;
import com.cg.dms.service.FarmerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
public class FarmerController {

	private static final Logger LOG = LoggerFactory.getLogger(FarmerController.class);

	@Autowired
	private FarmerService iFarmerService;

	@GetMapping("/farmer/all")
	public List<Farmer> getAllFarmer() {
		return iFarmerService.getAllFarmer();
	}

	@PostMapping("/farmer")
	public ResponseEntity<Farmer> addFarmer(@Valid @RequestBody Farmer farmer) throws FarmerAlreadyExistsException {
		LOG.info("Controller addfarmer");
		Farmer former = iFarmerService.addFarmer(farmer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " New former is added to the Database");
		LOG.info(headers.toString());
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(former, headers, HttpStatus.OK);
		return response;
	}

	@PutMapping("/farmer")
	public ResponseEntity<Farmer> updateFarmer(@Valid @RequestBody Farmer farmer) throws FarmerNotFoundException {
		LOG.info("Controller updatefarmer");
		Farmer former = iFarmerService.updateFarmer(farmer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This farmer data is updated in database.");
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(former, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/farmer/{farmerId}")
	public ResponseEntity<Farmer> getFarmerById(@Valid @PathVariable(name="farmerId") int farmerId) throws FarmerNotFoundException{
		LOG.info("getFarmer");
		Farmer farmer = iFarmerService.getFarmer(farmerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Farmer Id is Found ");
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(farmer, headers, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/sellmilk/{companyid}")
	public ResponseEntity<String> sellMilk(@PathVariable(name = "companyid")int companyid) throws CompanyNotFoundException{
		LOG.info("Controller updatefarmer");
		String sellmilk = iFarmerService.sellMilk(companyid);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This farmer data is updated in database.");
		ResponseEntity<String> response = new ResponseEntity<String>(sellmilk, headers, HttpStatus.OK);
		return response;
	}
	
}