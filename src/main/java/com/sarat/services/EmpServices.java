package com.sarat.services;

import java.util.List;

import com.sarat.entity.Employee;



public interface EmpServices {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee emp);
	public Employee update(Employee emp);
	public void deleteById(int id);

}
