package com.rev.managers;

import java.util.List;

import com.rev.models.Account;

public interface AccountManager {
	
	  Account createAccount(Account account);

	  Account findById(int id);
	  Account findByType(String type);

	  List<Account> findAll();
	    
	  void deleteAccount (Integer accountId);

	  List<Account> findByUser(int userId);


}
