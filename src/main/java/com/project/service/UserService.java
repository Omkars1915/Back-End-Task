package com.project.service;

import com.project.entity.User;

public interface UserService {

	String registerUser(User user);

	boolean loginuser(String username, String password);

	User getUserById(long id);

}
