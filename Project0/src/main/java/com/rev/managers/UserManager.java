package com.rev.managers;

import java.util.List;

import com.rev.models.User;

public interface UserManager {
	
	User findLogin(User user);

	User createAccount(User user);
	
	List<User> getUsers();
	
	User findById(int id);

}
