package com.rcan.springmvc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.rcan.springmvc.customerhandler.CustomerHandlerInterface;
import com.rcan.springmvc.customerhandler.CustomerHandler;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = ".com.rcan.springmvc")
public class Configer implements WebMvcConfigurer{
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/etsturcaseproject");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		return dataSource;
		
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views");
		resolver.setSuffix(".jsp");
		return resolver;
		}
	
	
	@Bean
	public CustomerHandlerInterface getCustomerHandler() {
		return new CustomerHandler(getDataSource());
	}

}
