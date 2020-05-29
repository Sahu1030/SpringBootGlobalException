package com.sarat.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	public DataSource securityDataSource;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
      auth.jdbcAuthentication().dataSource(securityDataSource);
//		auth.inMemoryAuthentication().withUser("sarat").password("{noop}admin1234").roles("USER");
//        auth.inMemoryAuthentication().withUser("sahu").password("{noop}admin1234").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("chandra").password("{noop}admin1234").roles("EMPLOYEE");
		
			}
	
	protected void configure(HttpSecurity http) throws Exception {
	// TODO Auto-generated method stub
	http.authorizeRequests()
    .antMatchers("/saveEmployee").hasRole("USER")//USER role can access /users/**
    .antMatchers("/deleteEmployee/**").hasRole("ADMIN")//ADMIN role can access /admin/**
    .antMatchers("/employee/**").hasRole("EMPLOYEE")//ADMIN role can access /employee/**
//    .antMatchers("/employees").permitAll()// anyone can access /quests/**
    .antMatchers("/").permitAll()// anyone can access /quests/**
    .anyRequest().authenticated()//any other request just need authentication
    .and()
    .formLogin();//enable form login
	

}

}
