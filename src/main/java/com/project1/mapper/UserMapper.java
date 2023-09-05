package com.project1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project1.domain.User;

@Mapper
public interface UserMapper {

	@Select("select * from user")
	List<User> findAll();
}
