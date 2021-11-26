package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {


}