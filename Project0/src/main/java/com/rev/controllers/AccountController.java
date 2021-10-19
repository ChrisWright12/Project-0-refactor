package com.rev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.rev.managers.AccountManager;
import com.rev.models.Account;

public class AccountController {
	
	@Autowired
	private AccountManager manager;


	private static final Logger logger = LogManager.getLogger(AccountController.class);

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/createQuiz", produces = "application/json", consumes = "application/json")
	public Account create(@RequestBody Account account) {
		logger.info("created new quiz");
		account = manager.createAccount(account);	
		return account;
	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="", produces = "application/json")
	public List<Account> getAll() {
		logger.info("GET to /accounts");
		return manager.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path = "/{accountId}", produces = "application/json")
	public ResponseEntity<String> deleteQuiz(@PathVariable("accountId") Integer accountId) {
	
		Account account = manager.findById(accountId);		
		manager.deleteAccount(accountId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
