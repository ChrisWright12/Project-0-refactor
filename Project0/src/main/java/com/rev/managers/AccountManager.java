package com.rev.managers;

import java.util.List;

import com.rev.models.Account;

public interface AccountManager {
	
	  Account create(Account account);

	  Account findById(int id);

	  List<Account> findAll();
	    
	  void deleteAccount (Integer accountId);

	  List<Account> findByUser(int userId);

	  Account findByName(String name);
	  List<Account> findBySearchValue(String searchValue);

}
