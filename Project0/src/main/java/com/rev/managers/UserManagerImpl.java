package com.rev.managers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.dao.UserDAO;
import com.rev.models.User;

@Service
public class UserManagerImpl implements UserManager {
	
	@Autowired
	private UserDAO uDao;
	
	@Override
	public User findLogin(User user) {
		User login = uDao.findLogin(user.getUsername());
		if(login != null && login.getPassword().equals(user.getPassword())) {
			login.setPassword(null);
			return login;
		}
		return null;
	}
	
	@Override
	@Transactional
	public User createUser(User user) {
		try {
			User login = findLogin(user);
			if(login == null) {
				uDao.save(user);
				user.setPassword(null);
				return user;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	@Override
	public List<User> getUsers() {
		return uDao.findAll();
	}
    @Override
    public User findById(int id) {
        return uDao.findById(id);
    }

}
