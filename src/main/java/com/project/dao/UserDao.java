package com.project.dao;

import java.util.List;

import com.project.entity.User;

public interface UserDao {

	String registerUser(User user);

	User loginUser(String username, String password);

	User getUserById(long id);

	List<User> getAllUser();

}
