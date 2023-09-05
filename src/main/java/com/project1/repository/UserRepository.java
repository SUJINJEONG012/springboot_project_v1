package com.project1.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project1.domain.User;

@Mapper
public interface UserRepository {

	@Select("select * from user")
	List<User> findAll();
}
