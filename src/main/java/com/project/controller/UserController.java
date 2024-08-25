package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.User;
import com.project.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		String registeruser=userservice.registerUser(user);
		return registeruser;
	}
	
	@GetMapping("/login/{username}/{password}")
	public String loginUser(@PathVariable String username, @PathVariable String password) {
		boolean loginuser=userservice.loginuser(username, password);
		if (loginuser) {
            return "Login successful";
        } else {
            return "Incorrect details";
        }
	}
	
	@GetMapping("/get-user-by-id/{id}")
		public User getUserById(@PathVariable long id) {
		User getuserbyid=userservice.getUserById(id);
			return getuserbyid;
		}
	
	
}
