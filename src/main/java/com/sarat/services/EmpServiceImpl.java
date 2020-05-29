package com.sarat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarat.dataJpa.EmpRepository;
import com.sarat.entity.Employee;


@Service
public class EmpServiceImpl implements EmpServices {
	
	private EmpRepository empRepository;
	
	@Autowired
	public EmpServiceImpl(EmpRepository empRepository) {
		super();
		this.empRepository = empRepository;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return (List) empRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp=empRepository.findById(id);
		Employee emplpyee =emp.get();
		return emplpyee;
	}


	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		empRepository.deleteById(id);
	}

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
//		empRepository.save(emp);
		empRepository.saveAndFlush(emp);
	}

	@Override
	public Employee update(Employee emp) {
		// TODO Auto-generated method stub
		return empRepository.save(emp);
	}

	

}
