package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dms.entities.Login;

public interface ILoginRepository extends JpaRepository<Login, Integer> {

	public abstract Login findByUserName(String username);

	public abstract Login existsByUserName(String user);

	public abstract Login findByUserPassword(String string);

}
