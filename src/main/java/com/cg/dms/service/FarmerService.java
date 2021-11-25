package com.cg.dms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.exception.FarmerAlreadyExistsException;
import com.cg.dms.exception.FarmerNotFoundException;
import com.cg.dms.repository.ICompanyRepository;
import com.cg.dms.repository.IFarmerRepository;

@Service
public class FarmerService implements IfarmerService {

	private static final Logger LOG = LoggerFactory.getLogger(FarmerService.class);
	@Autowired
	private IFarmerRepository iFarmerRepository;
	
	@Autowired
	private ICompanyRepository iCompanyRepository;
	
	public List<Farmer> getAllFarmer() {
		LOG.info("Get_All_Formers");
		return iFarmerRepository.findAll();
	}

	@Override
	public Farmer addFarmer(Farmer user) throws FarmerAlreadyExistsException {
		LOG.info("Service add Farmer");
		if (!iFarmerRepository.existsById(user.getFarmerId())) {
			LOG.info("New Farmer is Added");
			return iFarmerRepository.save(user);
		} else {
			LOG.info("Farmer Data is already exists");
			throw new FarmerAlreadyExistsException("Farmer already exists");
		}
	}

	@Override
	public Farmer updateFarmer(Farmer user) throws FarmerNotFoundException {
		LOG.info("Service update Farmer");
		if (iFarmerRepository.existsById(user.getFarmerId())) {
			LOG.info(" Farmer Data is Updated");
			return iFarmerRepository.save(user);
		} else {
			LOG.info(user.getFarmerId() + "  Farmer data is Not updated");
			throw new FarmerNotFoundException(" Farmer Data is not updated");
		}
	}

	@Override
	public String sellMilk(int companyid) throws CompanyNotFoundException{
		LOG.info("Buy Milk");
		if(iCompanyRepository.existsById(companyid)) {
			return "Milk sold successfully";
		}
		else {
		throw new  CompanyNotFoundException();
		}
	}


//	@Override
//	public Farmer validateFarmer(String username, String password) throws  FarmerNotFoundException {
//		Farmer far= new Farmer();
//		if(iFarmerRepository.existsby(username))
//		return iFarmerRepository.getById(far.getFarmerId());
//			else {
//				LOG.info(username+ "  Farmer not found");
//				throw new FarmerNotFoundException(" Farmer  not found");
//			}
//	}

}