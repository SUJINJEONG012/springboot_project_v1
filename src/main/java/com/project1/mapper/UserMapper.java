package com.project1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	List<Users> finaAll();

}
