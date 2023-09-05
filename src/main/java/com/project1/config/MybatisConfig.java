//package com.project1.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//
////스프링부트와 마이바티스를 연동할 때, SqlSessionFactory를 빈으로 등록해야 함.
//@Configuration
//public class MybatisConfig {
//	
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sqlSesionFactoryBean = new SqlSessionFactoryBean();
//		sqlSesionFactoryBean.setDataSource(dataSource);
//		sqlSesionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mapper/**.xml"));
//		
//		return sqlSesionFactoryBean.getObject();
//	}
//	
//	
///* SqlSessionTemplate은 마이바티스에서 제공하는 SqlSession 인터페이스의 구현체, Sql 실행 및 트랜잭션 관리를 담당
//   스프링부트와 마이바티스를 연동할 때, SqlSessionTemplate빈을 등록해야 함.
//*/	
//	@Bean
//	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//
//
//}
