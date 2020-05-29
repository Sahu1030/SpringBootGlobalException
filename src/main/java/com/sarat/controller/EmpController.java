package com.sarat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sarat.entity.Employee;
import com.sarat.services.EmpServiceImpl;



@RestController
//@RequestMapping("/Api")
public class EmpController {
	
	
	public EmpServiceImpl empServiceImpl;

	@Autowired
	public EmpController(EmpServiceImpl empServiceImpl) {
		super();
		this.empServiceImpl = empServiceImpl;
	}
	
	@GetMapping("/")
	public String guest(){
		return "Welcome to Spring Boot With DB Connection..";
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllemp(){
		List<Employee> list = empServiceImpl.findAll();
		return list;
	}
	
	@GetMapping("/employee/{empid}")
	public Employee findById(@PathVariable int empid){
		List<Employee> list = empServiceImpl.findAll();
		 		
		if(empid >= list.size() || empid<0)
		{
			throw new EmployNotFoundException("Employee Id not found - "+ empid);
		}
		Employee emp= empServiceImpl.findById(empid);
		return emp;
	}
	
	@GetMapping("/deleteEmployee/{empId}")
	public String deleteById(@PathVariable int empId){
//		Employee emp= empServiceImpl.findById(empId);
		List<Employee> list = empServiceImpl.findAll();
		System.out.println(empId);
		if(empId >= list.size())
		{
			throw new EmployNotFoundException("Employee Id not found - "+ empId);
		}
		empServiceImpl.deleteById(empId);
 		
		return "Deleted the record with id"+ empId;
	}
		
	@PostMapping("/saveEmployee")
	public Employee saveEmp(@RequestBody Employee emp){
		emp.setId(0);
		empServiceImpl.save(emp);
		
		return emp;
//		return "Record Saved Successfully";
	}
		
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmp(@RequestBody Employee emp,@PathVariable int id){
		emp.setId(id);
		empServiceImpl.save(emp);
		return emp;
	}
	

}
