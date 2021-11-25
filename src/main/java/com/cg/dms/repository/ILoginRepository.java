package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer> {
	
	public abstract Login findByUserName(String username);

	public abstract Login existsByUserName(String user);
//	User registerUser(User user);

//	@Query(value = "Select p From Party p Where Lower(p.partyName) = :name")
//	public Party readPartyByName(@Param("name") String partyName);
	

    public abstract  Login findByUserPassword(String string);

}
