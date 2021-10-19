package com.rev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rev.models.Account;

public interface AccountDAO extends JpaRepository<Account, Integer> {
	
	
	 	List<Account> findAll();

	 	Account findById(int id);

	    @Query("SELECT a FROM Account a WHERE a.user.id = ?1")
	    List<Account> findByUserId(int userId);

	    @Query("SELECT DISTINCT a FROM Account a WHERE a.name = ?1")
	    Account findByName(String name);
	    

}
