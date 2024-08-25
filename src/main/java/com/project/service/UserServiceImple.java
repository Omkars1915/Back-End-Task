package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;
import com.project.entity.User;
@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserDao userdao;

	@Override
	public String registerUser(User user) {
		String registeruser=userdao.registerUser(user);
		return registeruser;
	}

	@Override
	public boolean loginuser(String username, String password) {
		User user=userdao.loginUser(username,password);
		return user!=null;
	}

	@Override
	public User getUserById(long id) {
		User getuserbyid=userdao.getUserById(id);
		return getuserbyid;
	}

}
