package com.project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.domain.User;
import com.project1.mapper.UserMapper;

@Service
public class UserService {
	private final UserMapper userMapper;
	@Autowired
	public UserService(UserMapper userMapper) {
		this.userMapper=userMapper;
	}
	
	public List<User> finalAll(){
		return userMapper.findAll();
	}
}
