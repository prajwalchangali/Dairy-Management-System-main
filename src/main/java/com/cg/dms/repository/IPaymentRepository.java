
package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dms.entities.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}