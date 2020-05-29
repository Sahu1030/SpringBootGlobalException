package com.sarat.security;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@PropertySource("classpath:my_sql.properties")
public class DemoAppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver viedresolver()
	{
		InternalResourceViewResolver vr= new InternalResourceViewResolver();
		vr.setPrefix("WEB-INF/view/");
		vr.setSuffix(".jsp");
		
		return vr;
	}
	
	@Bean
	public DataSource securityDataSource() throws PropertyVetoException
	{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(env.getProperty("datasource.driver-class"));
		cpds.setJdbcUrl(env.getProperty("datasource.url"));
		cpds.setUser(env.getProperty("datasource.username"));
		cpds.setPassword(env.getProperty("datasource.password"));
				return cpds;
	}

}
