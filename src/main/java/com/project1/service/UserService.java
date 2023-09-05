package com.project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.domain.User;
import com.project1.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private  UserRepository userRepository;
	
	
	public List<User> finalAll(){
		return userRepository.findAll();
	}
}
