package com.rev.managers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.dao.AccountDAO;
import com.rev.models.Account;

@Service
public class AccountManagerImpl implements AccountManager {
	
    @Autowired
    private AccountDAO daoAccount;

    @Override
    public Account create(Account account){
        return daoAccount.save(account);
    }

    @Override
    public Account findById(int id) {
        return daoAccount.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return daoAccount.findAll();
    }

    @Override
	public void deleteAccount(Integer accountId) {
    	daoAccount.deleteById(accountId);
	}
    public List<Account> findByUser(int userId) {
        return daoAccount.findByUserId(userId);
    }

    @Override
    public Account findByType(String type) {
        return daoAccount.findByName(type);
    }

	@Override
	public List<Account> findBySearchValue(String searchValue) {
		return daoAccount.findBySearchValue(searchValue);
	}

}
