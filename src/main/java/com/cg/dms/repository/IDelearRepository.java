package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.Dealer;

@Repository
public interface IDelearRepository extends JpaRepository<Dealer, Integer> {

}