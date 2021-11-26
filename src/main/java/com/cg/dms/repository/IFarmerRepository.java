package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.Farmer;

@Repository
public interface IFarmerRepository extends JpaRepository<Farmer, Integer> {

	
	
}