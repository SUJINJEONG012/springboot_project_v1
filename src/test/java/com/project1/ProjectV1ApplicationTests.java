package com.project1;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ProjectV1ApplicationTests {

	@Autowired 
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	@Test
	void contextLoads() {
	}
	
	
	

}
